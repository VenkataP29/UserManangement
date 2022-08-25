package com.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.Admin;
import com.lab.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	
	public User findByEmail(String email);

	

}
