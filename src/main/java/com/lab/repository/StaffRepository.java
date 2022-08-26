package com.lab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

	public Staff findByEmail(String email);
	public Optional<Staff> findById(Integer id);
	public Staff save(Staff staff);
	
	@Query("SELECT s FROM Staff s WHERE s.name LIKE %?1% "
            + " OR s.email LIKE %?1% "
            + " OR s.age LIKE %?1%")
    public List<Staff> search(String keyword);


	
	
}
