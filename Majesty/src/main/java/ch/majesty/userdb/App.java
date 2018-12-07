package ch.majesty.userdb;
/*
 * PLU  31.10.2018
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("src/main/java")
@SpringBootApplication
public class App {


	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		User user = new User("Hans", "Tester" , 0,0);
		UserService us = new UserService();
		us.saveUser(user);
	}
}
