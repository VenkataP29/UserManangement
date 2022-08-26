package com.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lab.entity.Staff;
import com.lab.entity.User;
import com.lab.repository.StaffRepository;
import com.lab.repository.UserRepository;


public class StaffUserDetailsService implements UserDetailsService{

	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private StaffService staffService;
	
	@Override
	public StaffUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Staff staff = staffRepo.findByEmail(email);
		if(staff == null) {
			throw new UsernameNotFoundException("Email is not found");
		}
		return new StaffUserDetails(staff);
		
	}
	
	
}
