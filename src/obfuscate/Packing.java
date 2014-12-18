package obfuscate;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;

public class Packing {
	public static String pack(String compiledLocation, Obfuscator obf, byte key) throws IOException {
		String name = obf.getClassName();
		
		Path path = Paths.get(compiledLocation);

		byte[] b = Files.readAllBytes(path);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return buildUnpacker(Base64.encodeBase64(b), name, key);
	}

	private static String buildUnpacker(byte[] encoded, String name, byte key) {
		String unpacker =
			"package misc;"													+ "\n" +
			"import org.apache.commons.codec.binary.Base64;"				+ "\n" +
			"import java.lang.reflect.Method;"								+ "\n" +
			"public class Unpacker {"										+ "\n" +
			"	public static void main(String[] args) throws Exception {"		+ "\n" +
			"		String encoded = " + "\"" + new String(encoded) + "\";" 		+ "\n" +
			"		final byte[] b = Base64.decodeBase64(encoded);" 				+ "\n" +
			"		byte key = (byte) " + key + ";" 								+ "\n" +
			"		for (int i = 0; i < b.length; i++) {" 							+ "\n" +
			"			b[i] = (byte) (b[i] ^ key);"								+ "\n" +
			"		}"																+ "\n" +
			"		class ByteArrayClassLoader extends ClassLoader {"				+ "\n" +
			"			public Class<?> findClass(String name) {"					+ "\n" +
			"				return defineClass(name, b, 0, b.length);"				+ "\n" +
			"			}"															+ "\n" +
			"		}"																+ "\n" +
			"		Class<?> c = new ByteArrayClassLoader()"						+ "\n" +
			"				.findClass(" + "\"" + name + "\"" + ");"				+ "\n" +
			"				Method mthd = c.getMethod(\"main\", String[].class);"	+ "\n" +
			"		mthd.invoke(null, (Object) args);"								+ "\n" +
			"	}"																+ "\n" +
			"}";
		return unpacker;
	}
}
