package org.medellinjug.hackings;

public class HackingStrings {

	/*
	* Se requiere concatenar los números de un rango dado
	* */


	public static void usingString(int start, int end){
		String myString = "";
		for(int it=start; it<=end; it++ ) {
			myString = myString + it;
		}
	}

	public static void usingStringBuilder(int start, int end){
		StringBuilder myString = new StringBuilder("");
		for(int it=start; it<=end; it++ ) {
			myString.append(it);
		}
	}

}
