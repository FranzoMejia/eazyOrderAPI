package com.omejia.dto;


import lombok.Data;

@Data
public class CustomerDTO {


    private int id;
    private String name;
    private String email;
    private String mobileNumber;
    private String pwd;
    private String role;
    private String createDt;



}
