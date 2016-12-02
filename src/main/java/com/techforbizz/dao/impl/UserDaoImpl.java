package com.techforbizz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.techforbizz.dao.UserDao;
import com.techforbizz.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User getByEmailId(String emailid) {
		
		return (User) entityManager.createQuery("from User where emailid=:emailid").setParameter("emailid", emailid).getSingleResult();
	}

	@Override
	@Transactional
	public void createUser(User user) {
		
		entityManager.persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		return entityManager.createQuery("from User").getResultList();
	}

	@Override
	@Transactional
	public void updateUser(User user) {

		entityManager.merge(user);	
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		
		if (entityManager.contains(user))
			entityManager.remove(user);
		else
			entityManager.remove(entityManager.merge(user));
	}

}
