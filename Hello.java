package obfuscate;

import java.lang.management.ManagementFactory;


public class Hello {
	
	
	
	
	
	public static void main(String[] var8) {for( String var9 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var9.contains("-X" + "de" + "bug") || var9.contains("-a" + "g" + "" + "en" + "tlib")){   	System.out.println("" + "No " + "de" + "b" + "ugg" + "ers");   	System.exit(1);   }}for( String var9 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var9.contains("-X" + "de" + "bug") || var9.contains("" + "-a" + "ge" + "n" + "tlib")){   	System.out.println("No" + " " + "de" + "bug" + "gers");   	System.exit(1);   }}for( String var9 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var9.contains("" + "-Xd" + "ebug") || var9.contains("-ag" + "e" + "" + "ntl" + "ib")){   	System.out.println("" + "" + "" + "No " + "" + "d" + "eb" + "ugg" + "ers");   	System.exit(1);   }}for( String var9 : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(var9.contains("-X" + "de" + "bug") || var9.contains("-ag" + "e" + "n" + "tlib")){   	System.out.println("No" + " d" + "e" + "bug" + "gers");   	System.exit(1);   }}
        System.out.println("" + "H" + "" + "" + "ell" + "o, " + "Wo" + "rld" + var1(5));
    }
	
	public String var3() { return "s" + "t" + "ring"; }
	private static int var1(int var4) { return var4; }
	public String var2(String var5) {
		int var1 = 6;
		char var7 = 'a';
		
		return var5;
	}
}
