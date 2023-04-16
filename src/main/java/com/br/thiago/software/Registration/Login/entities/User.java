package com.br.thiago.software.Registration.Login.entities;

import jakarta.persistence.Entity;

@Entity
public class User extends Register {

	public User() {

	}

	public User(String name, String email, String user, String password, boolean Admin) {
		super(name, email, user, password, false);
	}
}
