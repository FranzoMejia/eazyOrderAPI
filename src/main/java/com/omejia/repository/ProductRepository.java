package com.omejia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omejia.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByactive(boolean active);
	
	List<Product> findById(int productid);

}
