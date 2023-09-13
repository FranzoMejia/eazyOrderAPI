package com.omejia.dto;

import lombok.Data;

@Data
public class ProductDTO {


        private int id;

        private String name;

        private String description;

        private String price;

        private boolean active=true;

    }
