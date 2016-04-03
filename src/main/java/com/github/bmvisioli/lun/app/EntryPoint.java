package com.github.bmvisioli.lun.app;

public class EntryPoint {

	public static final String WRONG_SYNTAX_MESSAGE = "Usage: java -jar <jar filename> [query <country>|reports]";
	
	protected static String handleInput(String[] input) {
		String result = WRONG_SYNTAX_MESSAGE;
		switch(input.length) {
			case 1:
				if(input[0].equals("reports")) {
					result = "reports";
				}
				break;
			case 2: 
				if(input[0].equals("query")) {
					result = "query";
				}
				break;
		}
		return result;
	}

}
