package ch.majesty.userdb;
/*
 * PLU  31.10.2018
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("src/main/java")
@SpringBootApplication
public class App {
	@Autowired
	static
	UserRepo blubb;
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		User bla = new User("bla", "bla", 0,0);
		blubb.save(bla);
	}
}
