package com.qa.Alphabet;

public class AlphabetReplace {
	public String replaceLetterWithPosition(String str) {
		str = str.toUpperCase();
		String convertedString = "";
		
		//Iterates through string, checks if ASCII value of char is within 65 to 90, adds ASCII value - 64 to return string
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)>64 && str.charAt(i)<91) convertedString +=(str.charAt(i) - 64 + " ");
		}
		
		//Remove space at end of string
		convertedString = convertedString.substring(0,convertedString.length()-1);
		
		return convertedString;
	}

}
