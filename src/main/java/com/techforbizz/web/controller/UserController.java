package com.techforbizz.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techforbizz.model.User;
import com.techforbizz.service.UserService;

@RestController
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public Iterable<User> getUsers() {
		
		log.info("Requesting to get all the users.");
		return userService.getUsers();
	}
}
