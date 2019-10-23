package com.yuu.util;

public class PrintTool {
	/**
	 * explanation : object
	 * @param explanation
	 * @param object
	 */
	public static void printWithColon(String explanation, Object object) {
		print(explanation, ":", object);
	}
	
	/**
	 * explanation:
	 * object
	 * @param explanation
	 * @param object
	 */
	public static void printWithWrap(String explanation, Object object) {
		print(explanation, ":\n", object);
	}
	
	private static void print(String explanation, String modifier, Object object) {
		if(explanation == null || explanation.length() == 0) {
			System.out.println(object);
			return;
		}
		System.out.println(explanation + modifier + object);
	}
	
	
	public static void main(String[] args) {
		printWithWrap("xxx", "wrap and otherContent!");
		printWithColon("explanation", "colon and otherContent!");
	}
}
