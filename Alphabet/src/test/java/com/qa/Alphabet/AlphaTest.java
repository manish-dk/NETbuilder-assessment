package com.qa.Alphabet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlphaTest {
	
	@Test
	public void alphabetTest() {
		AlphabetReplace ar = new AlphabetReplace();
		assertEquals("1 2 3", ar.replaceLetterWithPosition("ab2$ c"));
		assertEquals("20 8 9 19 14 5 20 2 21 9 12 4 5 18 1 19 19 5 19 19 13 5 14 20 9 19 23 1 25 20 15 15 5 1 19 25", ar.replaceLetterWithPosition("This NETbuilder assessment is way too easy."));
	}

}
