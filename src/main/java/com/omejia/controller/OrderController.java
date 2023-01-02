package com.omejia.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omejia.model.Client;
import com.omejia.model.Order;
import com.omejia.model.Status;
import com.omejia.repository.OrderRepository;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping
	public List<Order> getAllOrders(){
		return (List<Order>) orderRepo.findAll();
		
	}
	
	@GetMapping("/active")
	public List<Order> getActiveOrders(){
		return (List<Order>) orderRepo.findByactive(true);
	}
	
	@GetMapping("/inactive")
	public List<Order> getInactiveOrders(){
		return (List<Order>) orderRepo.findByactive(false);
	}
	
	@GetMapping("/{status}")
	public List<Order> getOrdersByStatus(@PathVariable Status status){
		return orderRepo.findBystatus(status);
	}
	
	@GetMapping("/get/{id}")
	public List<Order> getClient(@PathVariable int id){
		return orderRepo.findById(id);
	}
	
	@PostMapping
	public void saveOrder(@RequestBody Order order) {
		
		Timestamp now = Timestamp.valueOf(LocalDateTime.now());
		switch(order.getStatus())
		{
		case CREATED:
			order.setCreatedDt(now);
			break;
			
		case PREPARED:
			order.setPreparedDt(now);
			break;
		case SEND:
			order.setSendDt(now);
			break;
		case DELIVERED:
			order.setDeliveredDt(now);
			break;
		case CLOSED:
			order.setClosedDt(now);
			break;
		case CANCELLED:
			order.setCancelledDt(now);
			break;
		default:
			break;
		
		}
		orderRepo.save(order);
	}

}
