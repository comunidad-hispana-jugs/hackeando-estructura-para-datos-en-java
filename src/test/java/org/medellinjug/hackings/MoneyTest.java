package org.medellinjug.hackings;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

	@Test
	public void calculateBonusPercentage5Months() {
		Long salary = 10_000_000L;
		Long expectedBonus = 5_000_000L;
		Long bonus = HackingMoneys.calculateBonus( List.of( 0.1, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}

	@Test
	public void calculateBonusPercentage10Months() {
		Long salary = 10_000_000l;
		Long expectedBonus = 20_000_000L;
		Long bonus = HackingMoneys.calculateBonus( List.of(0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}
}
