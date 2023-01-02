package com.omejia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omejia.model.Address;


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	List<Address> findById(int addressid);
}
