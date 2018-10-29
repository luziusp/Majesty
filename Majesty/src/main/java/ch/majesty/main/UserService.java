package ch.majesty.main;



import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import model.User;
import repository.UserRepo;

//Source: https://www.javacodegeeks.com/2013/04/spring-jparepository-example-in-memory.html

@Service
public class UserService {
		
	private final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private ConfigurableEnvironment env;
	
	@Autowired
	UserRepo userrepo;

	//This function runs automatically after DB-creation to fill it with Test-Users. 
	//This is necessary because H2-Databases are wiped after restarting (in memory database).
	@PostConstruct
	public void populateDB() {
		String[] activeProfiles = env.getActiveProfiles();
		for(String profile : activeProfiles) {
			System.out.println(profile);
			if(profile.equalsIgnoreCase("dev")) {
				initDb();
			}
		}
	}
	//Register 2 test-users
	public void initDb() {
		LOG.info("Pre-populating DB");
		
		List<User> users = new ArrayList<User>();
		
		LOG.info("Create testuser1");
		User user1 = new User("Test1", "test");
		users.add(user1);
		System.out.println(user1);
		
		LOG.info("Create testuser2");
		User user2 = new User("Test2", "test");
		users.add(user2);
		
		userrepo.saveAll(users);
		
		LOG.info("Pre-Population done");
		
		
	}
	@Transactional(readOnly=true)
	public List<User> getAll() {
		        return userrepo.findAll();

		 
	}
	/*
	 @Transactional
	 	    public void delete(long id) {
	 	       userrepo.delete(id);
	 }
		*/ 
}
