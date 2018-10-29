package ch.majesty.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.majesty.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByLogin(String login);
}
