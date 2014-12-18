package obfuscate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Replacing {
	
	private static final Set<String> namesToIgnore = new HashSet<String>(Arrays.asList(
		new String[] {"main", "init"}
	));

	static int nameId = 0;
	
	public static String replaceAllNames(String content, Obfuscator obf){
		//Replace method names
		content = replaceNames(content, obf.getMethods());
		//Replace variable names
		content = replaceNames(content, obf.getVariables());
		//Replace class name
		ArrayList<String> classNameArr = new ArrayList<String>();
		classNameArr.add(obf.getSimpleClassName());
		//Note: You will need to change the file name as well
		//TODO uncomment?
//		content = replaceNames(content, classNameArr);
		return content;
	}
	
	public static String replaceNames(String content, ArrayList<String> strs){
		for(String s : strs){
			if(!namesToIgnore.contains(s)){
				// "\b" stands for a word boundary
				content = content.replaceAll("\\b" + s + "\\b", getNextName());
			}
		}
		return content;
	}
	
	private final static String getNextName(){
		nameId++;
		return "var" + nameId;
	}

}
