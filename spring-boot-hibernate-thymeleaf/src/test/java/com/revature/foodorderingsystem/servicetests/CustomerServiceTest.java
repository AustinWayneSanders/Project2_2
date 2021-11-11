package com.revature.foodorderingsystem.servicetests;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.foodorderingsystem.configuration.TestConfiguration;
import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.repository.CustomerRepository;
import com.revature.foodorderingsystem.service.CustomerService;

// following example at https://www.appsdeveloperblog.com/test-restful-web-service-junit-mockito/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class CustomerServiceTest {
	
	@Mock
    private CustomerRepository customerRepo;
	private Customer c1 = new Customer(1, "Holly", "Larsen", "hollar@email.com", "holly11", "l@r$3n");
	private Customer c2 = new Customer(2, "Nancy", "Selfridge", "nansel@email.com", "nancy22", "$3lfridg3");
    
    @Autowired
    @InjectMocks
    CustomerService customerService;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
    public void testCreateOrUpdateCustomer() {
    	// mocking customer repository method
    	when(customerRepo.save(c1)).thenReturn(c1);
    	
    	// call createOrUpdateCustomer
    	Customer result = customerService.createOrUpdateCustomer(c1);
    	
    	// Assert expected results
    	Assert.assertNotNull(result);
        Assert.assertEquals(result.toString(), c1.toString());
    }
    
    @Test
	public void testGetAllCustomers() {
		//////////////////// Test for empty array when nothing in db //////////////////
		// mock repo method
		when((List<Customer>) customerRepo.findAll()).thenReturn(new ArrayList<Customer>());
		
		// call getAllCustomers
	    List<Customer> result = customerService.getAllCustomers();
	    
	    // assert expected results
	    Assert.assertNotNull(result);
	    Assert.assertTrue(result.size() == 0);
	    
	    //////////////////// Test on non-empty db //////////////////// 	
		// build mock db & mock customer methods
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		
		// mocking customer repository method
		when(customerRepo.findAll()).thenReturn(customers);
		
		// call getAllCustomers
		result = customerService.getAllCustomers();
	
	    // Assert expected results
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == customers.size());
		for (int i = 0; i < result.size(); i++) {
			Customer rc = result.get(i);
			Customer c = customers.get(i);
	        Assert.assertEquals(rc.toString(), c.toString());
		}
	}
    
    @Test
    public void testGetCustomerById() {
    	//////////////////// Test for exception on empty db ////////////////////
    	try {
			customerService.getCustomerById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ////////////////////
    	// mocking customer repository method
        Optional<Customer> c = Optional.of(c1);
    	when(customerRepo.findById((long) 1)).thenReturn(c);
    	c = Optional.of(c2);
    	when(customerRepo.findById((long) 2)).thenReturn(c);
    	
    	// call getCustomerById
    	Customer result;
    	try {
		    result = customerService.getCustomerById(c1.getId());
		    
	    	// assert expected results
	    	Assert.assertNotNull(result);
	        Assert.assertEquals(c1.toString(), result.toString());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
    
        //////////////////// Test on non-empty db for non-existent user ////////////////////
	    try {
		    customerService.getCustomerById((long) 2);
	    } catch (RecordNotFoundException e) {
		    Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
	    }
    }
    
    @Test
    public void testDeleteCustomerById() {
    	//////////////////// Test on empty db ////////////////////
    	try {
			customerService.deleteCustomerById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ///////////////////
    	// mocking customer methods
    	List<Customer> customers = new ArrayList<Customer>();
    	customers.add(c1);
    	customers.add(c2);
    	
    	// mocking repo methods
      	doAnswer(invocation -> {
      		customers.remove(c1);
      		return null;
      	}).when(customerRepo).deleteById((long) 1);
      	
      	// call deleteById
      	try {
      		customerService.deleteCustomerById((long) 1);
      		
      		// assert expected results
      		Assert.assertFalse(customers.contains(c1));
      	} catch (RecordNotFoundException e) {
      		e.printStackTrace();
      	}
    	
    	//////////////////// Test on non-empty db for non-existent user ////////////////////
      	try {
      		customerService.deleteCustomerById((long) 1);
      	} catch (RecordNotFoundException e) {
      		Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
      	}
    }
    
    @Test
    public void testGetCustomerByUserName() throws RecordNotFoundException {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		
		when(customerRepo.findAll()).thenReturn(customers);
		
		Customer result = customerService.getCustomerByUserName(c1.getUserName());
		
		Assert.assertEquals(result.toString(), c1.toString());
		
		
    }
}

