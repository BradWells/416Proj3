package obfuscate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import spoon.Launcher;
import spoon.support.compiler.FileSystemFile;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Parameter;
import com.martiansoftware.jsap.Switch;

/*
 * Command line 
 */
public class ObfCLI {

	private static byte KEY = (byte) 0xF0;

	public static void main(String[] args) throws Exception {
		//Start gathering parameters
		JSAP jsap = new JSAP();

		//Parameters
		FlaggedOption fileopt = new FlaggedOption("file").setRequired(true)
				.setShortFlag('f').setLongFlag("file");
		FlaggedOption outopt = new FlaggedOption("output").setRequired(true)
				.setShortFlag('o').setLongFlag("output");

		Switch noComments = new Switch("nocomments").setShortFlag('c')
				.setLongFlag("nocomments");
		Switch stringObf = new Switch("stringobf").setShortFlag('s')
				.setLongFlag("stringobf");
		Switch rename = new Switch("rename").setShortFlag('r')
				.setLongFlag("rename");
		Switch pack = new Switch("pack").setShortFlag('p')
				.setLongFlag("pack");	
		Switch antiDebug = new Switch("antidebug").setShortFlag('d')
				.setLongFlag("antidebug");
		Switch noWhitespace = new Switch("nowhitespace").setShortFlag('w')
				.setLongFlag("nowhitespace");
		
		//Parameter to print the file, no compilation.
		Switch print = new Switch("print").setShortFlag('t')
				.setLongFlag("print");

		Parameter[] params = { fileopt, outopt, noComments, antiDebug, 
				rename, print, stringObf, pack, noWhitespace };

		//Store the parameters
		for (Parameter p : params) {
			jsap.registerParameter(p);
		}
		
		//Load the parameters
		JSAPResult config = jsap.parse(args);

		//Error message
		if (!config.success()) {

			System.err.println();

			for (java.util.Iterator errs = config.getErrorMessageIterator(); errs
					.hasNext();) {
				System.err.println("Error: " + errs.next());
			}

			System.err.println();
			System.err.println("Usage: java " + ObfCLI.class.getName());
			System.err.println("                " + jsap.getUsage());
			System.err.println();
			System.err.println(jsap.getHelp());
			System.exit(1);
		}

		String filename = config.getString("file");
		String content = readFile(filename, Charset.defaultCharset());
		
		Obfuscator obf = new Obfuscator(filename);

		if (config.getBoolean("nocomments")) {
			content = obf.removeComments(content);
		}
		if (config.contains("antidebug")) {
			content = obf.addAntiDebugger(content);
		}
		if (config.getBoolean("stringobf")) {
			content = obf.stringObfuscate(content);
		}
		if (config.getBoolean("rename")) {
			content = Replacing.replaceAllNames(content, obf);
		}
		if (config.getBoolean("nowhitespace")){
			content = obf.removeExtraWhitespace(content);
		}
		
		if(config.getBoolean("print")){
			System.out.println(content);
			System.out.println();
		}
		
		PrintWriter writer = new PrintWriter(config.getString("output"));
		writer.write(content);
		writer.close();

	    try {
	    	runProcess("javac " + config.getString("output"));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    String name = config.getString("output");
		String classFilename = name.substring(0, name.lastIndexOf(".")) + ".class";
		if (config.getBoolean("pack")) {
			String packedContent = Packing.pack(classFilename, obf, KEY);
			if(config.getBoolean("print")){
				System.out.println(packedContent);
			}
			PrintWriter classWriter = new PrintWriter("Pack.class");
			classWriter.write(packedContent);
			classWriter.close();
		}

	}

	// http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	//http://stackoverflow.com/questions/4842684/how-to-compile-run-java-program-in-another-java-program
	private static void runProcess(String command) throws Exception {
	    Process pro = Runtime.getRuntime().exec(command);
	    pro.waitFor();
	}
}
