package com.omejia.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


 class SecurityCustomerTest {
    private Customer getCustomer(){
        Customer cust = new Customer();
        cust.setId(1);
        cust.setName("Customer Name");
        cust.setEmail("cust@email.com");
        cust.setMobileNumber("3312429563");
        cust.setPwd("pwd");
        cust.setRole("ADMIN");
        cust.setCreateDt(LocalDate.now().toString());

        Set<Authority> authorities = new HashSet<>();
        Authority auth = new Authority();
        auth.setCustomer(cust);
        auth.setId(1L);
        auth.setName("Read");

        cust.setAuthorities(authorities);
        return cust;
    }

    @Test
    public void testSecurityCustomer(){

        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assert(cust.equals(cust));

    }
    @Test
    public void testGetAuthorities()
    {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assert (!sc.getAuthorities().isEmpty());

    }
    @Test
    public void testGetPassword()
    {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertEquals(cust.getPwd(),sc.getPassword());
    }
    @Test
    public void testgetUsername()
    {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertEquals(cust.getEmail(),sc.getUsername());
    }

    @Test
    public void testisAccountNonExpired() {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertTrue(sc.isAccountNonExpired());

    }
    @Test
    public void testisAccountNonLocked() {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertTrue(sc.isAccountNonLocked());
    }
    @Test
    public void testisCredentialsNonExpired() {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertTrue(sc.isCredentialsNonExpired());
    }
    @Test
     void testisEnabled() {
        Customer cust = this.getCustomer();
        SecurityCustomer sc = new SecurityCustomer(cust);
        assertTrue(sc.isEnabled());
    }
}
