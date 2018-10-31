package ch.majesty.userdb;
/*
 * PLU  31.10.2018
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



//Source: https://www.javacodegeeks.com/2013/04/spring-jparepository-example-in-memory.html

@Service
public class UserService {
		
	private final Logger LOG = LoggerFactory.getLogger(UserService.class);
	

	
	@Autowired
	UserRepo userrepo;
	
	@PersistenceContext
	 private EntityManager em;

	@Transactional(readOnly=true)
	public List<User> getAll() {
		        return userrepo.findAll();
	}
	
	@Transactional
	public  User save(User user) {
		return userrepo.save(user);
	}
		 
	
	/*
	 @Transactional
	 	    public void delete(long id) {
	 	       userrepo.delete(id);
	 }
		*/
}
