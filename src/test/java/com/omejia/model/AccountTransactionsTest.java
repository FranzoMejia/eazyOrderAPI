package com.omejia.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


 class AccountTransactionsTest {
    @Test
     void testAccountTransaction()
    {
        AccountTransactions at = new AccountTransactions();
       assertNotNull(at);

    }
}
