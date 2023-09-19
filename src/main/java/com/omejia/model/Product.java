package com.omejia.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "active")
	private boolean active=true;
	


	

}
