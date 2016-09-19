package com.doug;

import com.doug.configuration.SpringMongoConfiguration;
import com.doug.domain.Customer;
import com.doug.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMongoConfiguration.class)
public class CustomerDataTests {

	@Autowired
	CustomerRepository customerRepository;


	static final int QTY = 1;

	@Before
	public void init() {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("Doug", "Safford"));


	}

	@Test
	public void HappyTest() {
		List<Customer> list = customerRepository.findAll();
		Assert.assertEquals(QTY, list.size());
	}


}
