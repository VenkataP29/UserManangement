package com.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lab.entity.Admin;
import com.lab.entity.Staff;
import com.lab.repository.StaffRepository;
import com.lab.service.StaffService;


@RestController
@RequestMapping("/")
public class StaffController {
	
	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private StaffService staffService;
	
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
		System.out.println(email);
		return mav;
	}
	
	@GetMapping("/staffHome")
	public ModelAndView getThisUser(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView("StaffPage");
		Optional<Staff> staff = staffRepo.findById(id);
		mav.addObject("staff", staff);
		return mav;
	}
	@PostMapping("/signon")
	public ModelAndView addUser() {
		
		ModelAndView mav = new ModelAndView("StaffRegisterForm");
		Staff staff = new Staff();
		mav.addObject("staff",staff);
		return mav;
	}
	@PostMapping("/createStaff")
	public ModelAndView createStaff( Staff staff1) {
		ModelAndView mav = new ModelAndView("StaffHome");
		Staff staff = staffRepo.save(staff1);
		mav.addObject("staff", staff);
		System.out.println(staff);
		return mav;
	}
	
	
	@PostMapping("/saveStaff")
	public RedirectView saveStaff(@ModelAttribute Staff staff) {
		staffRepo.save(staff);
		return new RedirectView("/getStaffPage");
	}
	
	@PostMapping("/updateStaff")
	public ModelAndView saveSingleStaff(@ModelAttribute Staff staff) {
		ModelAndView  mav = new ModelAndView("StaffHome");
		mav.addObject("staff", staff);
		staffRepo.save(staff);
		return mav;
	}
	
	@GetMapping("/getSingleStaffRecod")
	public ModelAndView getSingleStaff(@RequestParam String email) {
		 ModelAndView mav = new ModelAndView("StaffHome");
		 
		 Staff staff = staffRepo.findByEmail(email);
		 System.out.println(staff);
		 mav.addObject("staff", staff);
		 return mav;
	}
	
	@GetMapping("/getStaffPage")
	public ModelAndView getStaff() {
		ModelAndView mav = new ModelAndView("StaffList");
		List<Staff> staff = (List<Staff>) staffRepo.findAll();
		mav.addObject("staff", staff);

		return findPaginated(0,mav);
	}
	
	@GetMapping("/showUpdatePage")
	public ModelAndView getUpdateStaffForm(@RequestParam String email) {
		ModelAndView mav = new ModelAndView("addStaffForm");
		Staff staff = staffRepo.findByEmail(email);
		mav.addObject("staff", staff);
	//	mav.setViewName("StaffRegisterForm");
		return mav;
	}
	
	@GetMapping("/saveUpdateStaff")
	public ModelAndView saveUser(@RequestParam String email) {
		ModelAndView mav = new ModelAndView("addStaff");
		Staff staff = staffRepo.findByEmail(email);
		mav.addObject("staff", staff);
		staffRepo.save(staff);
		return mav;
	//	return new RedirectView("/getSingleStaffRecord");
	}
	
	@GetMapping("/deleteStaff")
	public RedirectView deleteStaff(@RequestParam Integer Id) {
		staffRepo.deleteById(Id);	
		return new RedirectView("/getStaffPage");
	}
	
	@GetMapping("/page/{pageno}")
	public ModelAndView findPaginated(@PathVariable(value="pageno") int pageno,ModelAndView mav) {
		ModelAndView mav1 = new ModelAndView("StaffList");
		Page<Staff> staffList = staffService.findPage(pageno,7);
		mav1.addObject("staff",staffList);
		mav1.addObject("currentPage", pageno);
		mav1.addObject("totalPages", staffList.getTotalPages());
		mav1.addObject("totalItem",staffList.getContent());
		return mav1;
	}
	
	@GetMapping("/search")
	public ModelAndView searchResult(@Param("keyword") String keyword) {
		ModelAndView mav = new ModelAndView("SearchPage");
		List<Staff> staffList = staffService.getByKeyword(keyword);
		mav.addObject("staff", staffList);
		mav.addObject("keyword", keyword);
		
		return mav;
	}
}
