package test;

import ch.majesty.userdb.User;
import ch.majesty.userdb.UserService;
import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
	public class DbTester {
		public static void main(String[] args) {
			User user = new User("Hans", "Tester" , 0,0);
			UserService us = new UserService();
			us.saveUser(user);

			
		}
}
