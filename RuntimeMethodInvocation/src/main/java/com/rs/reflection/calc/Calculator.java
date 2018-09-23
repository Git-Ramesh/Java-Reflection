package com.rs.reflection.calc;

import java.util.Arrays;

/**
 * Able to handle the basic calculator functions.
 * 
 * @author ramesh
 */
public class Calculator {

	/**
	 * Performs addition by taking n number of parameters as an input.
	 * 
	 * @param nums
	 * @return sum
	 */
	public long addition(long... nums) {
		return Arrays.stream(nums).sum();
	}

	/**
	 * Performs substraction of given n number elements.
	 * 
	 * @param nums
	 * @return sub
	 */
	public long subtaction(long... nums) {
		return Arrays.stream(nums).reduce((num1, num2) -> num1 - num2).getAsLong();
	}

	public static String description() {
		return "Calculator operations available here";
	}

	private String getAuthor() {
		return "-Ramesh";
	}
}
