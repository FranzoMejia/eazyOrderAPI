package com.omejia.controller;

import java.util.List;

import com.omejia.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omejia.model.Client;
import com.omejia.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping("/{id}")
	public List<Client> getClient(@PathVariable int id){
		return clientRepo.findById(id);
	}
	
	@GetMapping
	public List<Client> getAllClients(){
		return clientRepo.findByactive(true);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable int id){
		 List<Client> clientToDelete = clientRepo.findById(id);
		 clientToDelete.get(0).setActive(false);
		 clientRepo.save(clientToDelete.get(0));
	}
	
	@PostMapping
	public void addClient(@RequestBody ClientDTO clientDto){
		Client client = new Client();
		client.setActive(true);
		client.setId(clientDto.getId());
		client.setAddresses(clientDto.getAddresses());
		client.setName(clientDto.getName());
		client.setPhone(clientDto.getPhone());


		 clientRepo.save(client);
	}
	
	
	

}
