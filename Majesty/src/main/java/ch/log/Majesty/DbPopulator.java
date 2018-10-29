package ch.log.Majesty;



import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import model.User;
import repository.UserRepo;



@Service
public class DbPopulator {
		
	private final Logger LOG = LoggerFactory.getLogger(DbPopulator.class);
	
	@Autowired
	private ConfigurableEnvironment env;
	
	@Autowired
	UserRepo userrepo;
	
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
	public void initDb() {
		LOG.info("Pre-populating DB");
		
		List<User> users = new ArrayList<User>();
		
		LOG.info("Create testuser1");
		User user1 = new User("Test1", "test");
		users.add(user1);
		
		LOG.info("Create testuser2");
		User user2 = new User("Test2", "test");
		users.add(user2);
		
		userrepo.saveAll(users);
		
		LOG.info("Pre-Population done");
		
		
	}
	
}
