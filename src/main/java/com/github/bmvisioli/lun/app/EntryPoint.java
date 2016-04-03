package com.github.bmvisioli.lun.app;

public class EntryPoint {

	public static final String NO_OPTION_MESSAGE = "Usage: java -jar <jar filename> [query <country>|reports]";
	
	protected static String handleInput(String[] input) {
		String result = null;
		if(input.length == 0) {
			return NO_OPTION_MESSAGE;
		}
		return result;
	}

}
