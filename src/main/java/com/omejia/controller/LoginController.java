package com.omejia.controller;


import java.security.Principal;
import java.time.LocalDate;

import java.util.List;


import com.omejia.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		if (!customers.isEmpty()) {
			return customers.get(0);
		}else {
			return null;
		}
		
	}
	
	

	@PostMapping("/createUser")
	public Customer createUserDetails(@RequestBody CustomerDTO customerDto) {
		Customer customer = new Customer();

		String pwd = customerDto.getPwd();
		customer.setPwd(passwordEncoder.encode(pwd));
		customer.setCreateDt(LocalDate.now().toString());
		customer.setId(customerDto.getId());
		customer.setName(customerDto.getName());
		customer.setRole(customerDto.getRole());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customerRepository.save(customer);
		return customer;
		
	}
	
	
	
	

}
