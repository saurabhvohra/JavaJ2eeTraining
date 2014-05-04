package com.agilemaple.common;

import java.util.Arrays;
import java.util.List;

public class Utils {
	public static List<String> convertStringIntoList(String input, String delimiter){
		String [] raw = input.split(delimiter);
		return Arrays.asList(raw);		
	}
}
