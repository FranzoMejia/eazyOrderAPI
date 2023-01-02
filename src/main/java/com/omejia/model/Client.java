package com.omejia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "active")
	@JsonIgnore
	private boolean active=true;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  
	@JoinColumn(name="address_id")
	private List<Address> addresses;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public Client(int id, String name, String phone, List<Address> addresses,boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.addresses = addresses;
		this.active = active;
	}


	public Client() {
		super();
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
