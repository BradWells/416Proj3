package obfuscate;


public class Hello {
    public static void main(java.lang.String[] args) {
        for (java.lang.String x : java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if ((x.contains("-Xdebug")) || (x.contains("-agentlib"))) {
                java.lang.System.out.println("No debuggers");
                java.lang.System.exit(1);
            } 
        }
        for (java.lang.String x : java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if ((x.contains("-Xdebug")) || (x.contains("-agentlib"))) {
                java.lang.System.out.println("No debuggers");
                java.lang.System.exit(1);
            } 
        }
        for (java.lang.String x : java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if ((x.contains("-Xdebug")) || (x.contains("-agentlib"))) {
                java.lang.System.out.println("No debuggers");
                java.lang.System.exit(1);
            } 
        }
        java.lang.System.out.println(("Hello, World" + (obfuscate.Hello.num(5))));
    }

    public java.lang.String str() {
        return "string";
    }

    private static int num(int number) {
        return number;
    }

    public java.lang.String fields(java.lang.String returnString) {
        int num = 6;
        char character = 'a';
        return returnString;
    }
}

