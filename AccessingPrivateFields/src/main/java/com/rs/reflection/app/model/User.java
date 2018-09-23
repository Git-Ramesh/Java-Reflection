package com.rs.reflection.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
	private static final long serialVersionUID = 4584947128133807448L;

	private static int instanceCount;

	private String username;
	private Set<Long> phones = new HashSet<>();

	public User() {
		System.out.println("User: 0-param constr");
		++User.instanceCount;
		System.out.println("Objects Created? " + User.instanceCount);
	}
}
