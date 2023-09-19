package com.omejia.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "price")
	private String  price;
	
	@Column(name = "status")
	private Status status= Status.CREATED;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address addresses;
	
	@OneToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  
	@JoinColumn(name="orderproduct_id")
	private List<OrderProduct> orderProduct;
	
	@Column(name = "paidmethod")
	private String paidMethod;
	
	@Column(name = "paidTo")
	private String paidTo;
	
	@Column(name = "deliveredBy")
	private String deliveredBy;
	
	@Column(name = "createdDt")
	@Basic
	private Timestamp createdDt=  Timestamp.valueOf(LocalDateTime.now());
	
	@Column(name = "preparedDt")
	@Basic
	private Timestamp preparedDt;
	
	@Column(name = "sendDt")
	@Basic
	private Timestamp sendDt;
	
	@Column(name = "cancelledDt")
	@Basic
	private Timestamp cancelledDt;
	
	@Column(name = "deliveredDt")
	@Basic
	private Timestamp deliveredDt;
	
	@Column(name = "closedDt")
	@Basic
	private Timestamp closedDt;
	
	
	@Column(name = "active")
	@Basic
	private boolean active=true;



	
}
