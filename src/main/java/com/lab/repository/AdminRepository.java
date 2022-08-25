package com.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer>{

	public Admin save(Admin admin);
	
}

