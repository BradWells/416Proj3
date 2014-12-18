package misc;

import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Method;

public class Packer {
	public static void main(String[] args) throws Exception {
		String encoded = "Og5KTvDw8MPwk/rw6PDa+vDb8Nz78N3w3vvw3/DA+/DB8ML78MHww/fwxPjwxfrw9/DG+PDH+fDI8Mn48Mr68MvwzPrwyPDN9/DO+vD/8Nr48M/68P/wsPrw5/Cx+vD/8LL68P/ws/jwtPfwtffwtvHw9syZnpmEzvHw89jZpvHw9LOflJXx8P+8mZ6VvoWdkpWCpJGSnJXx8PSdkZme8fDm2Ku8mpGGkd+ckZ6X36OEgpmel8vZpvHw/aOEkZObvZGApJGSnJX38Lf38MTx8PSGkYLD8fDk2Nm8mpGGkd+ckZ6X36OEgpmel8vx8PSGkYLB8fD02LnZufHw9IaRgsLx8NbYvJqRhpHfnJGel9+jhIKZnpfL2byakYaR35yRnpffo4SCmZ6Xy/Hw+qOfhYKTlbaZnJXx8Pq4lZycn96akYaR/PDp8Or38Lj88Lnwuvfwu/zwvPC99/C+/PC/8KD38Lf88KHwovzwo/Ck8fDgmpGGkd+ckZ6X36OEgpmel/Hw992olJWShZf88KXwpvHw+d2Rl5WehJyZkvfwp/zwqPCp8fD8vp/QlJWShZeXlYKD9/Cq/PCr8Kz88K3wrvHw55qRhpHfnJGel9+jhIKZnpeyhZmclJWC8fD8uJWcnJ/c0KefgpyU/PCv8JD88NTw1fzwr/CR/PCS8NPx8PeGkYLDmZ6X8fD/n5KWhYOTkYSV37iVnJyf8fDgmpGGkd+ckZ6X37+SmpWThPHw4pqRhpHfhYSZnN+5hJWCkYSfgvHw1pqRhpHfnJGel9+dkZ6Rl5WdlZ6E372RnpGXlZ2VnoS2kZOEn4KJ8fDgl5WEooWehJmdlb2ospWRnvHw1tjZvJqRhpHfnJGel9+dkZ6Rl5WdlZ6E36KFnoSZnZW9qLKVkZ7L8fDSmpGGkd+ckZ6X352RnpGXlZ2VnoTfooWehJmdlb2ospWRnvHw4ZeVhLmegIWEsYKXhZ2VnoSD8fDi2Nm8mpGGkd+FhJmc37yZg4TL8fD+mpGGkd+FhJmc37yZg4Tx8PiZhJWCkYSfgvHw5tjZvJqRhpHfhYSZnN+5hJWCkYSfgsvx8PeYkYO+lYiE8fDz2Nmq8fD0npWIhPHw5NjZvJqRhpHfnJGel9+/kpqVk4TL8fD4k5+ehJGZnoPx8OvYvJqRhpHfnJGel9+zmJGCo5WBhZWek5XL2arx8OCakYaR35yRnpffo4mDhJWd8fDzn4WE8fDlvJqRhpHfmZ/foIKZnoSjhIKVkZ3L8fDjmpGGkd+Zn9+ggpmehKOEgpWRnfHw94CCmZ6EnJ7x8OXYvJqRhpHfnJGel9+jhIKZnpfL2abx8PSViJmE8fD02LnZpvHw9pGAgJWelPHw3di8mpGGkd+ckZ6X36OEgpmel8vZvJqRhpHfnJGel9+jhIKZnpeyhZmclJWCy/Hw7Ni52byakYaR35yRnpffo4SCmZ6XsoWZnJSVgsvx8PiEn6OEgpmel/DR8Ofw6PDw8PDw9fDx8Onw6vDx8Ovw8PDt8PHw8fDw8PXaR/DxQfDw8PHw7PDw8Pbw8fDw8Pbw+fDt8O7w8fDr8PDxZfDz8PPw8PHVSPDySfDz8fBJ8PTx8LzbSfD18fBp8N7bSfD28fAw8Pe93OL4RvD5avD83OL6RvD5afD/QvD74vxG8P30SPD+Vw8/SPDySfDz8fBJ8PTx8LzbSfD18fBp8N7bSfD28fAw8Pe93OL4RvD5avD83OL6RvD5afD/QvD74vxG8P30SPD+Vw8/SPDySfDz8fBJ8PTx8LzbSfD18fBp8N7bSfD28fAw8Pe93OL4RvD5avD83OL6RvD5afD/QvD74vxG8P30SPD+Vw8/SPDySfDz8fBJ8PTx8LzbSfD18fBp8N7bSfD28fAw8Pe93OL4RvD5avD83OL6RvD5afD/QvD74vxG8P30SPD+Vw8/QvD7S/D/qUfw4OLhRvDi+Ejw40bw5Ebw5Ubw/UHw8PDy8Ozw8PD+8PPw8PD88fjw/fHU8P7w7/Dw8Lrw4Azw/vfw0Azw1Pfw0Qrw+wrw8gzw/ffw0Azw1Pfw0Qrw+wrw8gzw/ffw0Azw1Pfw0Qrw+wrw8gzw/ffw0Azw1Pfw0Qrw+wrw8vDx8NLw0/Dx8Ovw8PDr8PHw8fDw8PPi5kDw8PDx8Ozw8PD28PHw8PDg8Prw1PDV8PHw6/Dw8Orw8fDx8PDw8upc8PDw8fDs8PDw9vDx8PDw4fDx8Nbw1/Dx8Ovw8PDY8PHw9PDw8Pjg9s3gkc7bQPDw8PHw7PDw8P7w8/Dw8OPw8/Dk8Pbw5vDx8Njw8PDy8Nk=";
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
		Class<?> c = new ByteArrayClassLoader().findClass("obfuscate.Hello");
		Method mthd = c.getMethod("main", String[].class);
		mthd.invoke(null, (Object) args);
	}
}