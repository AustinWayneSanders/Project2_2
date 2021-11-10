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
import com.revature.foodorderingsystem.service.BillingStatementService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/billingStatements")
public class BillingStatementController 
{
	@Autowired
	BillingStatementService service;
	
	@GetMapping("/billingStatements")
	public List<BillingStatement> getAllBillingStatements() 
	{
		return service.getAllBillingStatements();

	}
			
	@PutMapping(path = {"/billingStatements/{id}"})
	public ResponseEntity<BillingStatement> editBillingStatementById(@PathVariable(value = "id") Long id) 
							throws RecordNotFoundException 
	{
		BillingStatement billingStatement = service.getBillingStatementById(id);
		service.createOrUpdateBillingStatement(billingStatement);
		return ResponseEntity.ok(billingStatement);
	}
	
	@DeleteMapping(path = "/billingStatements/{id}")
	public Map<String, Boolean> deleteBillingStatementById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteBillingStatementById(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping(path = "/createBillingStatement")
	public BillingStatement createBillingStatement(@Valid @RequestBody BillingStatement billingStatement) 
	{
		return service.createOrUpdateBillingStatement(billingStatement);
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
//import com.revature.foodorderingsystem.model.BillingStatement;
//import com.revature.foodorderingsystem.service.BillingStatementService;
//
//
//@Controller
////@RequestMapping("/billingStatements")
//public class BillingStatementController 
//{
//	@Autowired
//	BillingStatementService service;
//
//	@RequestMapping("/billingStatements")
//	public String getAllProducts(Model model) 
//	{
//		List<BillingStatement> list = service.getAllBillingStatements();
//
//		model.addAttribute("billingStatements", list);
//		return "list-billingStatements";
//	}
//
//	@RequestMapping(path = {"/editBillingStatement", "/editBillingStatement/{id}"})
//	public String editBillingStatementById(Model model, @PathVariable("id") Optional<Long> id) 
//							throws RecordNotFoundException 
//	{
//		if (id.isPresent()) {
//			BillingStatement entity = service.getBillingStatementById(id.get());
//			model.addAttribute("billingStatement", entity);
//		} else {
//			model.addAttribute("billingStatement", new BillingStatement());
//		}
//		return "add-edit-billingStatements";
//	}
//	
//	@RequestMapping(path = "/deleteBillingStatement/{id}")
//	public String deleteBillingStatementById(Model model, @PathVariable("id") Long id) 
//							throws RecordNotFoundException 
//	{
//		service.deleteBillingStatementById(id);
//		return "redirect:/billingStatements";
//	}
//
//	@RequestMapping(path = "/createBillingStatement", method = RequestMethod.POST)
//	public String createOrUpdateBillingStatement(BillingStatement billingStatement) 
//	{
//		service.createOrUpdateBillingStatement(billingStatement);
//		return "redirect:/billingStatements";
//	}
//}