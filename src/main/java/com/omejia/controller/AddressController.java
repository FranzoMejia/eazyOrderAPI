package com.omejia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omejia.model.Address;

import com.omejia.repository.AddressRepository;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepo;
	
	@GetMapping("/{id}")
	public List<Address> getaddress(@PathVariable int addressid){
		return addressRepo.findById(addressid);
	}
	
	@GetMapping
	public List<Address> getAllAdresses(){
		return (List<Address>) addressRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable int clientId){
		addressRepo.deleteById(clientId);
	}
	
	@PostMapping()
	public void addAddress(@RequestBody Address client){
		addressRepo.save(client);
	}
	
	
	

}
