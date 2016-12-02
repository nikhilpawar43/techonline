package com.techforbizz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techforbizz.dao.UserDao;
import com.techforbizz.model.User;

@Service("userService")
public class UserService {

	/*@Autowired
	private UserRepository userRepository;*/
	
	@Autowired
	private UserDao userDao;
	
	public Iterable<User> getUsers() {
		
		/*return userRepository.findAll();*/
		
		return userDao.getAllUsers();
	}
}
