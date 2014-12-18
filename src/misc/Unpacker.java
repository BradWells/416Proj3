package misc;
import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Method;
public class Unpacker {
	public static void main(String[] args) throws Exception {
		String encoded = "Og5KTvDw8MPwk/rw6PDa+vDb8Nz78N3w3vvw3/DA+/DB8ML78MHww/fwxPjwxfrw9/DG+PDH+fDI8Mn48Mr68MvwzPrwyPDN9/DO+vD/8Nr48M/68P/wsPrw5/Cx+vD/8LL68P/ws/jwtPfwtffwtvHw9syZnpmEzvHw89jZpvHw9LOflJXx8P+8mZ6VvoWdkpWCpJGSnJXx8PSdkZme8fDm2Ku8mpGGkd+ckZ6X36OEgpmel8vZpvHw/aOEkZObvZGApJGSnJX38Lf38MTx8PSGkYLD8fDk2Nm8mpGGkd+ckZ6X36OEgpmel8vx8PSGkYLB8fD02LnZufHw9IaRgsLx8NbYvJqRhpHfnJGel9+jhIKZnpfL2byakYaR35yRnpffo4SCmZ6Xy/Hw+qOfhYKTlbaZnJXx8Pq4lZycn96akYaR/PDp8Or38Lj88Lnwuvfwu/zwvPC99/C+/PC/8KD38Lf88KHwovzwo/Ck8fDgmpGGkd+ckZ6X36OEgpmel/Hw992olJWShZf88KXwpvHw+d2Rl5WehJyZkvfwp/zwqPCp8fD8vp/QlJWShZeXlYKD9/Cq/PCr8Kz88K3wrvHw55qRhpHfnJGel9+jhIKZnpeyhZmclJWC8fD8uJWcnJ/c0KefgpyU/PCv8JD88NTw1fzwr/CR/PCS8NPx8PaDhIKZnpfx8P+fkpaFg5ORhJXfuJWcnJ/x8OCakYaR35yRnpffv5KalZOE8fDimpGGkd+FhJmc37mElYKRhJ+C8fDWmpGGkd+ckZ6X352RnpGXlZ2VnoTfvZGekZeVnZWehLaRk4Sfgonx8OCXlYSihZ6EmZ2VvaiylZGe8fDW2Nm8mpGGkd+ckZ6X352RnpGXlZ2VnoTfooWehJmdlb2ospWRnsvx8NKakYaR35yRnpffnZGekZeVnZWehN+ihZ6EmZ2VvaiylZGe8fDhl5WEuZ6AhYSxgpeFnZWehIPx8OLY2byakYaR34WEmZzfvJmDhMvx8P6akYaR34WEmZzfvJmDhPHw+JmElYKRhJ+C8fDm2Nm8mpGGkd+FhJmc37mElYKRhJ+Cy/Hw95iRg76ViITx8PPY2arx8PSelYiE8fDk2Nm8mpGGkd+ckZ6X37+SmpWThMvx8PiTn56EkZmeg/Hw69i8mpGGkd+ckZ6X37OYkYKjlYGFlZ6TlcvZqvHw4JqRhpHfnJGel9+jiYOElZ3x8POfhYTx8OW8mpGGkd+Zn9+ggpmehKOEgpWRncvx8OOakYaR35mf36CCmZ6Eo4SClZGd8fD3gIKZnoScnvHw5di8mpGGkd+ckZ6X36OEgpmel8vZpvHw9JWImYTx8PTYudmm8fD2kYCAlZ6U8fDd2LyakYaR35yRnpffo4SCmZ6Xy9m8mpGGkd+ckZ6X36OEgpmel7KFmZyUlYLL8fDs2LnZvJqRhpHfnJGel9+jhIKZnpeyhZmclJWCy/Hw+ISfo4SCmZ6X8NHw5/Do8PDw8PD18PHw6fDq8PHw6/Dw8O3w8fDx8PDw9dpH8PFB8PDw8fDs8PDw9vDx8PDw9vD58O3w7vDx8Ovw8PFl8PPw8/Dw8dVI8PJJ8PPx8Enw9PHwvNtJ8PXx8Gnw3ttJ8Pbx8DDw973c4vhG8Plq8Pzc4vpG8Plp8P9C8Pvi/Ebw/fRI8P5XDz9I8PJJ8PPx8Enw9PHwvNtJ8PXx8Gnw3ttJ8Pbx8DDw973c4vhG8Plq8Pzc4vpG8Plp8P9C8Pvi/Ebw/fRI8P5XDz9I8PJJ8PPx8Enw9PHwvNtJ8PXx8Gnw3ttJ8Pbx8DDw973c4vhG8Plq8Pzc4vpG8Plp8P9C8Pvi/Ebw/fRI8P5XDz9I8PJJ8PPx8Enw9PHwvNtJ8PXx8Gnw3ttJ8Pbx8DDw973c4vhG8Plq8Pzc4vpG8Plp8P9C8Pvi/Ebw/fRI8P5XDz9C8PtL8P+pR/Dg4uFG8OL4SPDjRvDkRvDlRvD9QfDw8PLw7PDw8P7w8/Dw8Pzx+PD98dTw/vDv8PDwuvDgDPD+9/DQDPDU9/DRCvD7CvDyDPD99/DQDPDU9/DRCvD7CvDyDPD99/DQDPDU9/DRCvD7CvDyDPD99/DQDPDU9/DRCvD7CvDy8PHw0vDT8PHw6/Dw8Ovw8fDx8PDw8+LmQPDw8PHw7PDw8Pbw8fDw8ODw+vDU8NXw8fDr8PDw6vDx8PHw8PDy6lzw8PDx8Ozw8PD28PHw8PDh8PHw1vDX8PHw6/Dw8Njw8fD08PDw+OD2zeCRzttA8PDw8fDs8PDw/vDz8PDw4/Dz8OTw9vDm8PHw2PDw8PLw2Q==";
		final byte[] b = Base64.decodeBase64(encoded);
		byte key = (byte) -16;
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		class ByteArrayClassLoader extends ClassLoader {
			public Class<?> findClass(String name) {
				return defineClass(name, b, 0, b.length);
			}
		}
		Class<?> c = new ByteArrayClassLoader()
				.findClass("obfuscate.Hello");
				Method mthd = c.getMethod("main", String[].class);
		mthd.invoke(null, (Object) args);
	}
}