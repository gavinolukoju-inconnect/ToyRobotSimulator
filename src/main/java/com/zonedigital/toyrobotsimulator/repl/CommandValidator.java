package com.zonedigital.toyrobotsimulator.repl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandValidator {
	
	private static boolean validPlaceCommand(final String instruction)  {

		System.out.println(instruction);
		
		String re1="((?:[a-z][a-z]+))";	// Word 1
		String re2=".*?";	// Non-greedy match on filler
		String re3="(\\d+)";	// Integer Number 1
		String re4=".*?";	// Non-greedy match on filler
		String re5="(\\d+)";	// Integer Number 2
		String re6=".*?";	// Non-greedy match on filler
		String re7="((?:[a-z][a-z]+))";	// Word 2

		Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(instruction);

		if (m.find())
		{
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validInstruction(final String instruction) {

		boolean result = false;

		if(instruction != null && !instruction.isEmpty()) {

			switch(instruction.trim().toUpperCase()) {
			case "MOVE":
				result = true;
				break;
			case "LEFT":
				result = true;
				break;
			case "RIGHT":
				result = true;
				break;
			case "REPORT":
				result = true;
				break;
			default:
				result = validPlaceCommand(instruction);
			}
		}

		return result;
	}
}
