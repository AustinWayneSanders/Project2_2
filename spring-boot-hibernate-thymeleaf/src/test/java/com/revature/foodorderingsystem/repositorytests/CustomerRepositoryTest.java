package com.revature.foodorderingsystem.repositorytests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.foodorderingsystem.configuration.TestConfiguration;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	private Customer customer;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Holly", "Larsen", "hollar@email.com", "holly11", "l@r$3n");
		customerRepo.save(customer);
	}
	
	@After
	public void tearDown() {
		customerRepo.delete(customer);
	}
	
	@Test
	public void createCustomer() {
		Customer c = new Customer(2, "unit", "test", "unittest@email.com", "blah", "halb");
		Customer result = customerRepo.save(c);
		Assert.assertEquals(c.toString(), result.toString());
		customerRepo.delete(result);
	}
	
	@Test
	public void getCustomerById() {
		Customer result = customerRepo.findById(customer.getId()).get();
		Assert.assertEquals(customer.toString(), result.toString());
	}
	
	@Test
	public void getAllCustomers() {
		List<Customer> result = (List<Customer>) customerRepo.findAll();
		Assert.assertFalse(0 == result.size());
	}
	
	@Test
	public void updateCustomer() {
		customer.setEmail("MyNewEmail@email.com");
		Customer result = customerRepo.save(customer);
		Assert.assertEquals(customer.toString(), result.toString());
	}
	
	@Test
	public void deleteEmployee() {
		List<Customer> allCustomers = (List<Customer>) customerRepo.findAll();
		int sizeBeforeDelete = allCustomers.size();
		customerRepo.delete(customer);
		allCustomers = (List<Customer>) customerRepo.findAll();
		int sizeAfterDelete = allCustomers.size();
		Assert.assertTrue(sizeBeforeDelete - 1 == sizeAfterDelete);
	}
}


