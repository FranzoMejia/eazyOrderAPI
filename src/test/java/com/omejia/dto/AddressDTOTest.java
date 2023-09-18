package com.omejia.dto;


import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class AddressDTOTest {
    @Test
    public void testAddressDTO() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(AddressDTO.class);


        System.out.println("probando");
    }

}
