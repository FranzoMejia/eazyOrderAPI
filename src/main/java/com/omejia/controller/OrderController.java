package com.omejia.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.omejia.dto.OrderDTO;
import com.omejia.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return orderRepo.findByactive(true);
	}
	
	@GetMapping("/inactive")
	public List<Order> getInactiveOrders(){
		return orderRepo.findByactive(false);
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
	public void saveOrder(@RequestBody OrderDTO orderDTO) {
		
		Timestamp now = Timestamp.valueOf(LocalDateTime.now());
		Order order = new Order();
		order.setOrderProduct(orderDTO.getOrderProduct());
		order.setId(orderDTO.getId());
		order.setActive(orderDTO.isActive());
		order.setAddresses(orderDTO.getAddresses());
		order.setClient(orderDTO.getClient());
		order.setComments(orderDTO.getComments());
		order.setStatus(orderDTO.getStatus());
		order.setDeliveredBy(orderDTO.getDeliveredBy());
		order.setPrice(orderDTO.getPrice());
		order.setPaidMethod(orderDTO.getPaidMethod());
		order.setPaidTo(orderDTO.getPaidTo());
		order.setCreatedDt(orderDTO.getCreatedDt());
		order.setPreparedDt(orderDTO.getPreparedDt());
		order.setSendDt(orderDTO.getSendDt());
		order.setDeliveredDt(orderDTO.getDeliveredDt());
		order.setClosedDt(orderDTO.getClosedDt());
		order.setCancelledDt(orderDTO.getCancelledDt());



		switch(orderDTO.getStatus())
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
