package ch.majesty.userdb;

/*
 * PLU  31.10.2018
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
}
