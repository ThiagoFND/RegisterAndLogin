package com.br.thiago.software.Registration.Login.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.thiago.software.Registration.Login.entities.Admin;
import com.br.thiago.software.Registration.Login.entities.Register;
import com.br.thiago.software.Registration.Login.entities.User;
import com.br.thiago.software.Registration.Login.repositories.RegisterRepository;

@Service
public class RegisterServices {

	@Autowired
	RegisterRepository RRepositories;

	// this method adds the user to the table in the database
	public void addUser(String name, String email, String user, String password) {
		User userSoftware = new User(name, email, user, password, false);
		RRepositories.save(userSoftware);
	}

	// this method adds the admin to the table in the database
	public void addAdmin(String name, String email, String user, String password) {
		Admin adminSoftware = new Admin(name, email, user, password, true);
		RRepositories.save(adminSoftware);
	}

	// this method checks and validates whether the software user is a user or an admin
	public User loginUser(String user, String password) {
		for (Register logUser : RRepositories.findAll()) {
			if (logUser.getUser().equals(user) && logUser.getPassword().equals(password) && !logUser.isAdmin()) {
				return (User) logUser;
			} else {
			}
		}
		return null;
	}

	// this method checks and validates whether the software user is a user or an admin
	public Admin loginAdmin(String user, String password) {
		// this for is looking for the table if the data matches
		for (Register logUser : RRepositories.findAll()) {
			// this if does the validation
			if (logUser.getUser().equals(user) && logUser.getPassword().equals(password) && logUser.isAdmin()) {
				return (Admin) logUser;
			} else {
			}
		}
		return null;
	}

}
