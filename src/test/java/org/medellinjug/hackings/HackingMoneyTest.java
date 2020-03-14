package org.medellinjug.hackings;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HackingMoneyTest {

	@Test
	public void calculateBonusWithDoubles5Months() {
		Long salary = 10_000_000L;
		Long expectedBonus = 5_000_000L;
		Long bonus = HackingMoneys.calculateBonusWithDoubles( List.of( 0.1, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}

	@Test
	public void calculateBonusWithDoubles10Months() {
		Long salary = 10_000_000l;
		Long expectedBonus = 20_000_000L;
		Long bonus = HackingMoneys.calculateBonusWithDoubles( List.of(0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}

	@Test
	public void calculateBonusWithBigDecimals5Months() {
		Long salary = 10_000_000L;
		Long expectedBonus = 5_000_000L;
		Long bonus = HackingMoneys.calculateBonusWithBigDecimal( List.of( 0.1, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}

	@Test
	public void calculateBonusWithBigDecimals10Months() {
		Long salary = 10_000_000l;
		Long expectedBonus = 20_000_000L;
		Long bonus = HackingMoneys.calculateBonusWithBigDecimal( List.of(0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1) , salary);

		assertEquals(expectedBonus, bonus);
	}
}
