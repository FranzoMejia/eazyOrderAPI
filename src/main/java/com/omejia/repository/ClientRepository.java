package com.omejia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.omejia.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
	
	List<Client> findById(int clientId);
	
	List<Client> findByactive(boolean active);

}
