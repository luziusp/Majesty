package ch.majesty.userdb;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Repository
public class UserService {

	
	@Autowired
	private UserRepo repo;
	
	@Transactional(readOnly=true)
	public List<User> getAll() {
		 return (List<User>) repo.findAll();
	}
	
	@Transactional
	public void saveUser(User user) {
		repo.save(user);
	}

}
