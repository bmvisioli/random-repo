package com.github.bmvisioli.lun.app;

import com.github.bmvisioli.lun.output.Query;
import com.github.bmvisioli.lun.output.Report;

public class EntryPoint {

	public static final String WRONG_SYNTAX_MESSAGE = "Usage: java -jar <jar filename> [query <country>|reports]";
	
	protected static String handleInput(String[] input) {
		String result = WRONG_SYNTAX_MESSAGE;
		switch(input.length) {
			case 1:
				if(input[0].equals("reports")) {
					result = new Report().build();
				}
				break;
			case 2: 
				if(input[0].equals("query")) {
					result = new Query(input[1]).build();
				}
				break;
		}
		return result;
	}

}
