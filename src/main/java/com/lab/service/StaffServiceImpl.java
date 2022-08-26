package com.lab.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lab.entity.Staff;
import com.lab.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffRepository staffRepo;
	
	@Override
	public Page<Staff> findPage(int currentPage, int size) {
		
		Pageable pageable = PageRequest.of(currentPage,size);
		return staffRepo.findAll(pageable);
	}

	@Override
	public List<Staff> staffDetails(String keyword) {

		if(keyword != null) {
			return staffRepo.search(keyword);
		}
		return staffRepo.findAll();
	}

}
