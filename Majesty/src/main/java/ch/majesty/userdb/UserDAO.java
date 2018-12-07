package ch.majesty.userdb;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
// PLU
//https://o7planning.org/en/11705/create-a-login-application-with-spring-boot-spring-security-jpa#a13934220
@Repository
@Transactional
public class UserDAO {
	 @Autowired
	   private EntityManager entityManager;
	 public User findUserAccount(String userName) {
	        try {
	            String sql = "Select e from " + User.class.getName() + " e " //
	                    + " Where e.userName = :userName ";
	 
	            Query query = entityManager.createQuery(sql, User.class);
	            query.setParameter("userName", userName);
	 
	            return (User) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }
}
