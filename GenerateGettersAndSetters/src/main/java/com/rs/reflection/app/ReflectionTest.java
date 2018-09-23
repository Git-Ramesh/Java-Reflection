package com.rs.reflection.app;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.rs.reflection.app.model.User;

public class ReflectionTest {

	public static void main(String[] args) {
		Class<User> clazz = User.class;

		/*
		 * Get the all fields of model
		 */
		Field[] fields = clazz.getDeclaredFields();
		Arrays.stream(fields).forEach(ReflectionTest::generateGettersAndSetters);
	}

	private static void generateGettersAndSetters(Field field) {
		if (field.getName().equals("serialVersionUID")) {
			return;
		}
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		System.out.println(genrateSetter(field));
		System.out.println();
		System.out.println();
		System.out.println(generateGetter(field));
	}

	private static String genrateSetter(Field field) {
		StringBuffer sb = new StringBuffer();
		sb.append("public void set");
		sb.append(StringUtils.capitalize(field.getName()));
		sb.append("(");
		sb.append(field.getType().getSimpleName());
		sb.append(" " + field.getName());
		sb.append(") {");
		sb.append("this." + field.getName() + " = ");
		sb.append(field.getName() + ";");
		sb.append("}");
		return sb.toString();
	}

	public static String generateGetter(Field field) {
		StringBuffer sb = new StringBuffer();
		sb.append("public ");
		sb.append(field.getType().getSimpleName());
		sb.append(" get");
		sb.append(StringUtils.capitalize(field.getName()));
		sb.append("() {");
		sb.append("return this." + field.getName() + ";");
		sb.append("}");
		return sb.toString();
	}
}