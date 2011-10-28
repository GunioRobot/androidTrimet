package com.fixedd.AndroidTrimet.util;


/**
 * Utility functions used by the library internally.
 * @author Jeremy Logan
 *
 */
public class Util {

	/**
	 * Convert an array of ints into a comma-separated string.
	 * @param lst
	 * @return
	 */
	public static String arrayIntsToString(int... lst) {
		String toReturn = "";

		for (int i=0; i<lst.length; i++) {
			toReturn = toReturn + Integer.toString(lst[i]) + ",";
		}

		return toReturn.subSequence(0, toReturn.length()-1).toString();
	}
}
