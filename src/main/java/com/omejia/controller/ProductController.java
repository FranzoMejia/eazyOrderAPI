package com.omejia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omejia.model.Product;
import com.omejia.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/all")
	public List<Product> getProducts(){
		List<Product> products = productRepo.findByactive(true);
		if(products!=null)
			return  products;
		else
			return null;
	}
	
	@PostMapping("/add")
	public  Product addProduct(@RequestBody Product product) {
		
		return productRepo.save(product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Integer> deleteProduct(@PathVariable Integer id) {

		 Optional<Product> toDelete = productRepo.findById(id);
		 if(toDelete != null)
		 {
			 toDelete.get().setActive(false);
			 productRepo.save(toDelete.get());
			 return new ResponseEntity<>(id, HttpStatus.OK);
		 }
	     return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
		
	}

}
