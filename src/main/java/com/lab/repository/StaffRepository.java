package com.lab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer>{

	public Staff findByEmail(String email);
	public Optional<Staff> findById(Integer id);
	public Staff save(Staff staff);

	
	
}
