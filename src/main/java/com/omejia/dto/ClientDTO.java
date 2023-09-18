package com.omejia.dto;


import com.omejia.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private int id;

    private String name;

    private String phone;

    private boolean active=true;

    private List<Address
            > addresses;

}
