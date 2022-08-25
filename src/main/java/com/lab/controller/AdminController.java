package com.lab.controller;

import java.util.List;

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
import com.lab.repository.AdminRepository;
import com.lab.repository.UserRepository;

@RestController
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepo;
	
	@GetMapping("/getStaff")
	public ModelAndView getAllStaff() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("StaffList");
		return  mav;
	}
	@GetMapping("/index")
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/admin/login")
	public ModelAndView getAdmin() {
		ModelAndView mav = new ModelAndView("adminLogin");
		Admin admin = new Admin();
		mav.addObject("admin",admin);
		return mav;
	}
	
	@PostMapping("/accessAdmin")
	public RedirectView getAdminAccess(@RequestParam String email) {
		userRepo.findByEmail(email);
	//	adminRepo.save(admin);
		return new RedirectView("/adminHome");
	}
	
	@GetMapping("/adminHome")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("adminHome");
		return mav;
	}
	
	@PostMapping("/adminLogout")
	public ModelAndView logoutPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Logout");
		return mav;
	}
}
