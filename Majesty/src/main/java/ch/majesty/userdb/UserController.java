package ch.majesty.userdb;
/*
 * PLU  31.10.2018
 */

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class UserController {
	@Autowired
	private UserRepo repo;
	
	@RequestMapping("/majesty/user")
	public List<User> listUser(){
		List<User> list = repo.findAll();
		return list;
	}
	@RequestMapping("/majesty")
	public User getById(Long id) {
		User user = repo.getOne(id);
		return user;
	}
}
