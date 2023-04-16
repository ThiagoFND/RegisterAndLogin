package com.br.thiago.software.Registration.Login.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Admin extends Register{

	public Admin() {
		
	}
	
	public Admin(String name, String email, String user, String password, boolean Admin) {
		super(name, email, user, password, true);
		this.setAdmin(true);
	}
}
