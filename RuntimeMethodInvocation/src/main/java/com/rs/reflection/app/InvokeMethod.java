package com.rs.reflection.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.rs.reflection.calc.Calculator;

public class InvokeMethod {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<Calculator> clazz = Calculator.class;

		// Gets the all methods declared in Calculator class
		// Method[] methods = clazz.getDeclaredMethods();
		// Arrays.stream(methods).forEach(System.out::println);

		// Get the Calculator instance(Creating the instance at runtime)
		Object calculator = clazz.newInstance();

		/*
		 * Invoking instance method at runtime
		 */
		// Call the method of Calculator instance (runtime method invocation)
		Method addition = clazz.getDeclaredMethod("addition", long[].class);
		long[] input = { 10, 20, 30 };
		long result = (long) addition.invoke(calculator, input);
		System.out.println("Addition: " + result);

		Method sub = clazz.getDeclaredMethod("subtaction", long[].class);
		long[] subInput = { 11, 1, 100 };
		long subResult = (long) sub.invoke(calculator, subInput);
		System.out.println("Substraction: " + subResult);

		/*
		 * Invoking static method at runtime
		 */
		Method description = clazz.getDeclaredMethod("description", new Class[] {});
		System.out.println((String) description.invoke(null, null));

		/*
		 * Invoking private methods
		 */
		Method getAuthor = clazz.getDeclaredMethod("getAuthor", null);
		getAuthor.setAccessible(true);
		System.out.println(getAuthor.invoke(calculator, null));
	}
}
