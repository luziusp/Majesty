package ch.majesty.userdb;

/*
 * PLU  31.10.2018
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByLogin(String login);
	
}
