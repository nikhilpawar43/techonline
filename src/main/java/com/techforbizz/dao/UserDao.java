package com.techforbizz.dao;

import java.util.List;

import com.techforbizz.model.User;

public interface UserDao {

	public User getByEmailId( String emailid );
	public void createUser( User user );
	public List<User> getAllUsers();
	public void updateUser( User user );
	public void deleteUser( User user);
}
