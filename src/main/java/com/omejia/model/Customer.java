package com.omejia.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;
	private String name;
	private String email;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String pwd;
	private String role;
	@Column(name = "create_dt")
	private String createDt;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	private Set<Authority> authorities;


	
}
