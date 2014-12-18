package obfuscate;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtSimpleType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.compiler.FileSystemFile;

public class Obfuscator {

	private  int SPLIT_MAX_LENGTH = 4;
	
	private CtClass discoveredClass;
	
	private static String[] unchangableMethodNames = {"main"};
	private static String[] unchangableVariableNames = {"args"};
	
	public Obfuscator(String filename) throws Exception{
		Launcher spoon = new Launcher();
		spoon.addInputResource(new FileSystemFile(new File(filename)));
		spoon.run();
		
		Factory factory = spoon.getFactory();
		
		// list all classes of the model
		for (CtSimpleType s : factory.Class().getAll()) {
			discoveredClass = (CtClass) s;
		}
	}
	
	public String getClassName(){
		return discoveredClass.getQualifiedName();
	}
	
	public String getSimpleClassName(){
		return discoveredClass.getSimpleName();
	}
	
	public ArrayList<String> getMethods(){
		ArrayList<String> methodStrings = new ArrayList<String>();
		
		for(Object m : discoveredClass.getMethods()){
			String methodName = ((CtMethod) m).getSimpleName();
			methodStrings.add(methodName);
		}
		
		return methodStrings;
	}
	
	public ArrayList<String> getVariables(){
		ArrayList<String> varStrings = new ArrayList<String>();
		for(Object m : discoveredClass.getMethods()){
			for(Object f : ((CtMethod) m).getElements(new TypeFilter(CtVariable.class))){
				String fieldName = ((CtVariable) f).getSimpleName();
				varStrings.add(fieldName);
			}
		}
		return varStrings;
	}

	public String stringObfuscate(String content) {
		Pattern p = Pattern.compile("\".+?\"");
		Matcher m = p.matcher(content);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group(0);
			// Trim off quotes
			text = text.substring(1, text.length() - 1);
			String replace = "";
			Random rand = new Random();
			while (text.length() > SPLIT_MAX_LENGTH) {
				int split_index = rand.nextInt(SPLIT_MAX_LENGTH);
				replace += "\"" + text.substring(0, split_index) + "\" + ";
				text = text.substring(split_index);
			}
			replace += "\"" + text + "\"";
			m.appendReplacement(sb, replace);
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/*
	 * Removes comments from the java file
	 */
	public String removeComments(String content) {
		// http://ostermiller.org/findcomment.html
		// This regex should replace all comments and replace them with an empty
		// string
		String new_content = content.replaceAll(
				"(?:/\\*(?:.|[\\n\\r])*?\\*/)|(?://.*)", "");
		return new_content;
	}
	
	public String removeExtraWhitespace(String content) {
		String new_content = content.replaceAll("\\s+"," ");
		return new_content;
	}
	
	/*
	 * Adds antidebugger code to the beginning of a main method of the java file, if it exists
	 */
	public String addAntiDebugger(String content){
		if (getMethods().contains("main")){
			// Help from http://blog.nibblesec.org/2013/01/anti-debugging-techniques-and-burp-suite.html
			String insertedCode =
			"for( String x : ManagementFactory.getRuntimeMXBean().getInputArguments()){" +
	        "   if(x.contains(\"-Xdebug\") || x.contains(\"-agentlib\")){" +
	        "   	System.out.println(\"No debuggers\");" +
	        "   	System.exit(1);" +
	        "   }" +
	        "}";
			// Find anything that might be the main method	
			Pattern p = Pattern.compile("main.*?\\(.*?\\).*?\\{");
			Matcher m = p.matcher(content);
			StringBuffer sb = new StringBuffer();
			while (m.find()) {
				String text = m.group(0);
				text += insertedCode;
				m.appendReplacement(sb, text);
			}
			m.appendTail(sb);
			return sb.toString();
		}
		else{
			System.out.println("No main method");
			return content;
		}
	}

}
