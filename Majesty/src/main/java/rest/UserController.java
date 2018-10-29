package rest;

import org.springframework.web.bind.annotation.RestController;

import model.User;
import repository.UserRepo;

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
