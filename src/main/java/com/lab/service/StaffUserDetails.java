package com.lab.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.lab.entity.Staff;
import com.lab.entity.User;

public class StaffUserDetails implements UserDetails {
	
	private Staff staff;
	
	public StaffUserDetails(Staff staff) {
		this.staff = staff;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	//	List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	//	authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		return null;
	}

	@Override
	public String getPassword() {
		return staff.getPassword();
	}

	@Override
	public String getUsername() {
		return staff.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
