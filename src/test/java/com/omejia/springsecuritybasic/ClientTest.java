package com.omejia.springsecuritybasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.omejia.model.Address;
import com.omejia.model.Client;
import com.omejia.model.Order;
import com.omejia.model.OrderProduct;
import com.omejia.model.Product;
import com.omejia.repository.AccountsRepository;
import com.omejia.repository.AddressRepository;
import com.omejia.repository.ClientRepository;
import com.omejia.repository.OrderProductRepository;
import com.omejia.repository.OrderRepository;
import com.omejia.repository.ProductRepository;

@SpringBootTest
public class ClientTest {
	
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private OrderProductRepository OrderproductRepo;
	

	
	
	

	
	@Test
    @Transactional
    @Rollback(false)
    public void check_sql_statement_when_persisting_in_one_to_many_unidirectional() {
		
			
		Order order = new Order();
		order.setComments("Entregar Rapido");
		order.setPrice("2222.50");
		
		Client client= clientRepo.findById(106).get(0);
		order.setClient(client);
		
		
		Address adress = addressRepo.findById(110).get(0);
		order.setAddresses(adress);
		
		List<OrderProduct> op = new ArrayList<OrderProduct>();
		OrderProduct orderP1 = new OrderProduct();
		orderP1.setQty(10);
		Product p1 = productRepo.findById(96).get(0);
		orderP1.setProduct(p1);
		op.add(orderP1);
		order.setOrderProduct(op);
		
		orderRepo.save(order);
	
		
	
		
		
		
		/*
		 * Address adress = new Address(); adress.setId(0); adress.setName("Casa");
		 * adress.setUrl(
		 * "https://www.google.com/maps/place/Calle+Villas+del+Ote.+14G,+Villas+Alcalde,+45190+Zapopan,+Jal./@20.7241358,-103.347178,15z/data=!4m5!3m4!1s0x8428b0317d427243:0xa26c8aa668234e2e!8m2!3d20.7186328!4d-103.3436546"
		 * );
		 * 
		 * 
		 * List<Address> addresses = new ArrayList<Address>();; addresses.add(adress);
		 * Client client1 = new Client(0,"Oscar Mejia","3312429563",addresses,true);
		 * clientRepo.save(client1);
		 */
		 
        
        
        
        
    }

}
