package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Address;
import domain.AddressRepository;
import domain.Student;
import domain.StudentRepository;
import domain.User;
import domain.UserRepository;
import domain.UserRole;
import domain.UserRolesRepository;

@Controller
public class StudentController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StudentRepository studentRepositorty;
	@Autowired
	private AddressRepository addressRepo;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(User user,HttpSession hs)
	{
		System.out.println("register called "+user);
		user.setEnabled(1);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User saveUser = userRepo.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUserid(saveUser.getUserid());
		UserRole userRole2 = userRolesRepository.save(userRole);
		System.out.println("After register called "+saveUser +" roles "+userRole2);
		return "redirect:info";
	}
	@RequestMapping(value="/register")
	public ModelAndView registerUserPage()
	{
		ModelAndView mv = new ModelAndView("register","user", new User());
		return mv;
	}
	@RequestMapping("/list")
	public String getStudentsList(HttpSession hs)
	{
		System.out.println("list called");
		List<Student> list = (List<Student>)studentRepositorty.findAll();
		hs.setAttribute("studentList", list);
		return "list";
	}
	
	@RequestMapping("/info")
	public String getAddressListByState(HttpSession hs,HttpServletRequest req)
	{	
		System.out.println("state list called");
		List<Address> list = (List<Address>)addressRepo.findDistinctState();
		hs.setAttribute("stateList", list);
		return "info";
	}
	
	@RequestMapping(value="/student")
	public String getStudentListByState(HttpSession hs,HttpServletRequest req)
	{
		System.out.println("state student list called");
		String state = req.getParameter("state");
		List<Student> list = (List<Student>)studentRepositorty.findByAddress_state(state);
		hs.setAttribute("stateStudentList", list);
		return "info";
	}
}
