package org.medellinjug.hackings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HackingStringTests {

	@Test
	@DisplayName("Concatenating numbers from 1 to 10 million ")
	public void usingString() {
		HackingStrings.usingString(1, 10_000_000);
	}

	@Test
	@DisplayName("Concatenating numbers from 1 to 10 million ")
	public void usingStringBuilder() {
		HackingStrings.usingStringBuilder(1, 10_000_000);
	}
}
