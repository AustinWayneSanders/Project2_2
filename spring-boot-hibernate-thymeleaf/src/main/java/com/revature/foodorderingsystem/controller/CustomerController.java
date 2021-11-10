package com.revature.foodorderingsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.service.BillingStatementService;
import com.revature.foodorderingsystem.service.CustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	@Autowired
	CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() 
	{
		return service.getAllCustomers();

	}
			
	@PutMapping(path = {"/customers/{id}"})
	public ResponseEntity<Customer> editCustomerById(@PathVariable(value = "id") Long id) 
							throws RecordNotFoundException 
	{
		Customer customer = service.getCustomerById(id);
		service.createOrUpdateCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	
	@DeleteMapping(path = "customers/{id}")
	public Map<String, Boolean> deleteBillingStatementById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteCustomerById(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping(path = "/createCustomer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) 
	{
		return service.createOrUpdateCustomer(customer);
	}
}






//package com.revature.foodorderingsystem.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.revature.foodorderingsystem.exception.RecordNotFoundException;
//import com.revature.foodorderingsystem.model.Customer;
//import com.revature.foodorderingsystem.service.CustomerService;
//
//@Controller
//@RequestMapping("/")
//public class CustomerController 
//{
//	@Autowired
//	CustomerService service;
//
//	@RequestMapping
//	public String getAllEmployees(Model model) 
//	{
//		List<Customer> list = service.getAllEmployees();
//
//		model.addAttribute("customers", list);
//		return "list-customers";
//	}
//
//	@RequestMapping(path = {"/edit", "/edit/{id}"})
//	public String editCustomerById(Model model, @PathVariable("id") Optional<Long> id) 
//							throws RecordNotFoundException 
//	{
//		if (id.isPresent()) {
//			Customer entity = service.getCustomerById(id.get());
//			model.addAttribute("customer", entity);
//		} else {
//			model.addAttribute("customer", new Customer());
//		}
//		return "add-edit-customer";
//	}
//	
//	@RequestMapping(path = "/delete/{id}")
//	public String deleteCustomerById(Model model, @PathVariable("id") Long id) 
//							throws RecordNotFoundException 
//	{
//		service.deleteCustomerById(id);
//		return "redirect:/";
//	}
//
//	@RequestMapping(path = "/createCustomer", method = RequestMethod.POST)
//	public String createOrUpdateEmployee(Customer customer) 
//	{
//		service.createOrUpdateCustomer(customer);
//		return "redirect:/";
//	}
//}