package com.omejia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.omejia.model.Order;
import com.omejia.model.Status;

public interface OrderRepository extends CrudRepository<Order,Integer>{
	List<Order> findBystatus(Status status);
	List<Order> findByactive(boolean status);
	List<Order> findById(int id);

}
