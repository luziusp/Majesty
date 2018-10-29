package repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByLogin(String login);
}
