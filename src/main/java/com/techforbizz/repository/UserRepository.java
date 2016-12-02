package com.techforbizz.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techforbizz.model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

}
