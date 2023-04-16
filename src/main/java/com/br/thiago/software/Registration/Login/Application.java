package com.br.thiago.software.Registration.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.thiago.software.Registration.Login.Services.Exceptions;
import com.br.thiago.software.Registration.Login.Services.RegisterServices;

/*
 * this software makes user and admin registration and login using a for verification and validation
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	RegisterServices RServices;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Exceptions exc1 = new Exceptions();

		int enterWhile1 = 0;
		while (enterWhile1 != 5) {
			System.out.println("[1] - Register \n[2] - Login \n[3] - Leave \nWrite: ");
			int value1 = exc1.readWhole();

			if (value1 == 1) {
				// register

				System.out.println("[1] - User \n[2] - Admin \nValue: ");
				int value2 = exc1.readWhole();

				if (value2 == 1) {
					// register user

					System.out.println("Name: ");
					String name = exc1.read();
					System.out.println("Email: ");
					String email = exc1.read();
					System.out.println("User: ");
					String user = exc1.read();
					System.out.println("Password: ");
					String password = exc1.read();

					RServices.addUser(name, email, user, password);

					System.out.println("User registred!");

				} else if (value2 == 2) {
					// register admin

					System.out.println("Name");
					String name = exc1.read();
					System.out.println("Email");
					String email = exc1.read();
					System.out.println("User");
					String user = exc1.read();
					System.out.println("Password");
					String password = exc1.read();

					RServices.addAdmin(name, email, user, password);

					System.out.println("Admin registred!");
				} else {
					System.out.println("Non-existent value");
				}
			} else if (value1 == 2) {
				// login
				System.out.println("[1] - User \n[2] - Admin \nValue: ");
				int value4 = exc1.readWhole();

				if (value4 == 1) {
					// login user

					System.out.println("User: ");
					String user = exc1.read();
					System.out.println("Password: ");
					String password = exc1.read();

					RServices.loginUser(user, password);

					if (RServices.loginUser(user, password) != null) {
						System.out.println("Successful login");
					} else {
						System.out.println("User or Password incorrect");
					}

				} else if (value4 == 2) {
					// login admin

					System.out.println("User: ");
					String user = exc1.read();
					System.out.println("Password: ");
					String password = exc1.read();

					RServices.loginAdmin(user, password);
					if (RServices.loginAdmin(user, password) != null) {
						System.out.println("Successful login");
					} else {
						System.out.println("User or Password incorrect");
					}
				} else {
					System.out.println("Non-existent value");
				}
			} else if (value1 == 3) {
				// leave
				System.out.println("Leave");
				break;
			}
		}
	}

}
