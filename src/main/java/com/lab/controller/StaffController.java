package com.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lab.entity.Admin;
import com.lab.entity.Staff;
import com.lab.repository.StaffRepository;


@RestController
@RequestMapping("/")
public class StaffController {
	
	@Autowired
	private StaffRepository staffRepo;
	
	@GetMapping("/login")
	public ModelAndView getAdmin() {
		ModelAndView mav = new ModelAndView("staffLogin");
		Staff staff = new Staff();
		mav.addObject("staff",staff);
		return mav;
	}
	
	@GetMapping("/accessStaff")
	public ModelAndView getAccess(@RequestParam String email) {
		ModelAndView mav = new ModelAndView("staffPage");
		Staff staff = staffRepo.findByEmail(email);
		mav.addObject("staff",staff);
		return mav;
	}
	
	@GetMapping("/staffHome")
	public ModelAndView getThisUser(@RequestParam String email) {
		ModelAndView mav = new ModelAndView("StaffPage");
		Staff staff = staffRepo.findByEmail(email);
		mav.addObject("staff", staff);
		return mav;
	}
	@GetMapping("/signon")
	public ModelAndView addAdmin() {
		ModelAndView mav = new ModelAndView("StaffRegisterForm");
		Staff staff = new Staff();
		mav.addObject("staff",staff);
		return mav;
	}
	@PostMapping("/createStaff")
	public ModelAndView saveStaff(@ModelAttribute Staff staff) {
		ModelAndView mav = new ModelAndView("StaffPage");
		Staff staff1 = new Staff();
		mav.addObject("staff", staff1);
//		staffRepo.save(staff);
//		return new RedirectView("/getStaffPage");
		return mav;
	}
	
	
	@GetMapping("/getStaffPage")
	public ModelAndView getStaff() {
		ModelAndView mav = new ModelAndView("StaffList");
		List<Staff> staff = (List<Staff>) staffRepo.findAll();
		mav.addObject("staff", staff);
		return mav;	
	}
	
	@GetMapping("/showUpdatePage")
	public ModelAndView getUpdateStaffForm(@RequestParam String email) {
		ModelAndView mav = new ModelAndView("addStaffForm");
		Staff staff = staffRepo.findByEmail(email);
		mav.addObject("staff", staff);
	//	mav.setViewName("StaffRegisterForm");
		return mav;
	}
	
	@PostMapping("/saveStaff")
	public RedirectView saveUser(@ModelAttribute Staff staff) {
		staffRepo.save(staff);
		return new RedirectView("/getStaffPage");
	}
	
	@GetMapping("/showDeleteStaff")
	public RedirectView getDeleteStaff(@RequestParam Integer id) {
		staffRepo.deleteById(id);
		return new RedirectView("/getStaffPage");
	}
	
}
