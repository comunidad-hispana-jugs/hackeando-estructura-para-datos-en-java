package org.medellinjug.hackings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTests {

	@Test
	@DisplayName("Printing numbers from 1 to 1 million ")
	public void usingString() {
		HackingStrings.usingString(1, 1000000);
	}

	@Test
	@DisplayName("Printing numbers from 1 to 1 million ")
	public void usingStringBuilder() {
		HackingStrings.usingStringBuilder(1, 1000000);
	}
}
