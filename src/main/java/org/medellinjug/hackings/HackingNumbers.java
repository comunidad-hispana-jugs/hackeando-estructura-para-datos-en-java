package org.medellinjug.hackings;

public class HackingNumbers {

	public static void main(String... args) {

		Integer int1 = 5;
		Integer int2 = 5;

		System.out.println(" = : " + (int1==int2) + "  Equals= "+ int1.equals(int2));

		int1 = 5_000;
		int2 = 5_000;

		System.out.println(" = : " + (int1==int2) + " Equals= "+ int1.equals(int2));

	}
}
