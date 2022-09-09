package com.lab.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lab.entity.Staff;

public interface StaffService {

	Page<Staff> findPage(int pageNo, int pageSize);
	
	public List<Staff> getByKeyword(String keyword);
	
	//public List<Staff> staffDetails(String keyword);
	
}
