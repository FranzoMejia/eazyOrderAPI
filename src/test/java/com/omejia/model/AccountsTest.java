package com.omejia.model;

import com.omejia.dto.AddressDTO;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class AccountsTest {
    @Test
    public void testAccounts() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Accounts.class);

    }
}
