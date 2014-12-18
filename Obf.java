package obfuscate;

import java.lang.management.ManagementFactory;


public class Hello {
	
	
	
	
	
	public static void main(String[] var8) {for( String var4 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var4.contains("-Xd" + "ebug") || var4.contains("" + "-ag" + "ent" + "lib")){   	System.out.println("" + "No" + " de" + "bu" + "" + "g" + "gers");   	System.exit(1);   }}for( String var4 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var4.contains("-" + "Xd" + "ebug") || var4.contains("" + "-" + "ag" + "" + "ent" + "lib")){   	System.out.println("N" + "o d" + "e" + "b" + "u" + "gge" + "rs");   	System.exit(1);   }}for( String var4 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var4.contains("" + "" + "-Xd" + "ebug") || var4.contains("-ag" + "en" + "tlib")){   	System.out.println("" + "" + "" + "No " + "deb" + "ug" + "gers");   	System.exit(1);   }}for( String var4 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var4.contains("-" + "X" + "d" + "ebug") || var4.contains("" + "-" + "" + "a" + "g" + "en" + "tlib")){   	System.out.println("No " + "deb" + "" + "" + "ugg" + "ers");   	System.exit(1);   }}
        System.out.println("" + "" + "H" + "e" + "ll" + "o," + "" + "" + " " + "Wo" + "rld" + var1(5));
    }
	
	public String var3() { return "st" + "ring"; }
	private static int var1(int var4) { return var4; }
	public String var2(String var5) {
		int var1 = 6;
		char var7 = 'a';
		
		return var5;
	}
}
