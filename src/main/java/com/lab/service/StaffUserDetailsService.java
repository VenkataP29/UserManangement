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

@Service
public class StaffUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Email is not found");
		}
		return new StaffUserDetails(user);
		
	}
	
	
}
