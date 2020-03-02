package org.medellinjug.hackings;

public class HackingStrings {

	/*
	* Se requiere concatenar los números del 1 al 1 millón
	* */


	public static void usingString(int start, int end){
		String myString = "";
		for(int it=start; it<=end; it++ ) {
			myString = myString + it;
		}
	}

	public static void usingStringBuilder(int start, int end){
		StringBuffer myString = new StringBuffer("");
		for(int it=start; it<=end; it++ ) {
			myString.append(it);
		}
	}

}
