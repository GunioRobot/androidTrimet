package com.fixedd.AndroidTrimet.util;

import java.util.List;

/**
 * Utility functions used by the library internally.
 * @author Jeremy Logan
 *
 */
public class Util {

	/**
	 * Convert a List<Integer> into a comma-separated string.
	 * @param lst 
	 * @return
	 */
	public static String listIntegersToString(List<Integer> lst) {
		String toReturn = "";
		
		for (int i=0; i<lst.size(); i++) {
			toReturn = toReturn + lst.get(i).toString() + ",";
		}
		
		return toReturn.substring(0, -1);
	}
	
}
