package com.omejia.dto;

import com.omejia.model.Address;
import com.omejia.model.Client;
import com.omejia.model.OrderProduct;
import com.omejia.model.Status;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class OrderDTO {

    private int id;

    private String comments;

    private String  price;

    private Status status= Status.CREATED;

    private Address addresses;

    private Client client;

    private List<OrderProduct> orderProduct;

    private String paidMethod;

    private String paidTo;

    private String deliveredBy;

    private Timestamp createdDt=  Timestamp.valueOf(LocalDateTime.now());

    private Timestamp preparedDt;

    private Timestamp sendDt;

    private Timestamp cancelledDt;

    private Timestamp deliveredDt;

    private Timestamp closedDt;

    private boolean active=true;
}
