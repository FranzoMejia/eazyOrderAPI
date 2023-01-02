package com.omejia.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omejia.model.Customer;
import com.omejia.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customers = customerRepository.findByEmail(user.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		}else {
			return null;
		}
		
	}
	
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "customer_id") private int id; private String name; private
	 * String email;
	 * 
	 * @Column(name = "mobile_number") private String mobileNumber;
	 * 
	 * @JsonIgnore private String pwd; private String role;
	 * 
	 * @Column(name = "create_dt") private String createDt;
	 */
	@PostMapping("/createUser")
	public Customer createUserDetails(@RequestBody Customer customer) {
		String pwd = customer.getPwd();
		customer.setPwd(passwordEncoder.encode(pwd));
		customer.setCreateDt(LocalDate.now().toString());
		customerRepository.save(customer);
		return customer;
		
	}
	
	
	
	

}
