package obfuscate;

import java.lang.management.ManagementFactory;

/*
 * Sample File to obfuscate
 */
public class Hello {
	
	// Comment
	// Comment
	/* comment */
	/*
	 * 
	 * Comment
	 */
	public static void main(String[] args) {for( String x : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(x.contains("-Xdebug") || x.contains("-agentlib")){   	System.out.println("No debuggers");   	System.exit(1);   }}for( String x : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(x.contains("-Xdebug") || x.contains("-agentlib")){   	System.out.println("No debuggers");   	System.exit(1);   }}for( String x : ManagementFactory.getRuntimeMXBean().getInputArguments()){   if(x.contains("-Xdebug") || x.contains("-agentlib")){   	System.out.println("No debuggers");   	System.exit(1);   }}
        System.out.println("Hello, World" + num(5));
    }
	
	public String str() { return "string"; }
	private static int num(int number) { return number; }
	public String fields(String returnString) {
		int num = 6;
		char character = 'a';
		
		return returnString;
	}
}
