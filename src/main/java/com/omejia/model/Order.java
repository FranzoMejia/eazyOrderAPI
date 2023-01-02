package com.omejia.model;


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
	
	
	
	public Timestamp getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}

	public String getPaidMethod() {
		return paidMethod;
	}

	public void setPaidMethod(String paidMethod) {
		this.paidMethod = paidMethod;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}


	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}

	public String getDeliveredBy() {
		return deliveredBy;
	}

	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	public Timestamp getPreparedDt() {
		return preparedDt;
	}

	public void setPreparedDt(Timestamp preparedDt) {
		this.preparedDt = preparedDt;
	}

	public Timestamp getSendDt() {
		return sendDt;
	}

	public void setSendDt(Timestamp sendDt) {
		this.sendDt = sendDt;
	}

	public Timestamp getCancelledDt() {
		return cancelledDt;
	}

	public void setCancelledDt(Timestamp cancelledDt) {
		this.cancelledDt = cancelledDt;
	}

	public Timestamp getDeliveredDt() {
		return deliveredDt;
	}

	public void setDeliveredDt(Timestamp deliveredDt) {
		this.deliveredDt = deliveredDt;
	}

	public Timestamp getClosedDt() {
		return closedDt;
	}

	public void setClosedDt(Timestamp closedDt) {
		this.closedDt = closedDt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	
}
