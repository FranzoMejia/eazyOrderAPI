package com.omejia.springsecuritybasic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.omejia.model.Client;
import com.omejia.repository.ClientRepository;

@SpringBootTest
class SpringsecuritybasicApplicationTests {

	
	@Autowired
	private ClientRepository clientRepo;
	
	@Test
	void contextLoads() {
		List<Client> listExample = new ArrayList<>();
		listExample =clientRepo.findByactive(false);
		
		
	}

}
