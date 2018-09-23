package com.rs.reflection.app;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.rs.reflection.app.model.User;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		Class<User> clazz = User.class;

		/*
		 * Create User Instance
		 */
		User user = clazz.newInstance();

		Field field = clazz.getDeclaredField("instanceCount");
		field.setAccessible(true);
		// Change the value field value using reflection
		field.set(null, 0);
		User user1 = clazz.newInstance();
		/*
		 * Get the all fields
		 */
		Field[] fields = clazz.getDeclaredFields();

		// Creating Stream and printing it using internal iterator
		Arrays.stream(fields).forEach(System.out::println);
	}
}
