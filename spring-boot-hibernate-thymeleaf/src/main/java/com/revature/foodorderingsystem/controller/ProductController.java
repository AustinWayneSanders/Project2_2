//package com.revature.foodorderingsystem.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
////import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.foodorderingsystem.exception.RecordNotFoundException;
//import com.revature.foodorderingsystem.model.Product;
//import com.revature.foodorderingsystem.service.ProductService;
//
////@CrossOrigin(origins="http://localhost:4200")
////@RestController
//@Controller
//@RequestMapping("/products")
//public class ProductController 
//{
//	@Autowired
//	ProductService service;
//	
////	@GetMapping("/products-list")
////	public List<Product> getAllProducts() 
////	{
////		return service.getAllProducts();
////	}
//
//	@RequestMapping("/products-list")
//	public String getAllProducts(Model model) 
//	{
//		List<Product> list = service.getAllProducts();
//
//	    model.addAttribute("products", list);
//
//	    return "list-products";
//	}
//
//	@RequestMapping(path = {"/editProduct", "/editProduct/{id}"})
//	public String editProductById(Model model, @PathVariable("id") Optional<Long> id) 
//							throws RecordNotFoundException 
//	{
//		if (id.isPresent()) {
//			Product entity = service.getProductById(id.get());
//			model.addAttribute("product", entity);
//		} else {
//			model.addAttribute("product", new Product());
//		}
//		return "add-edit-products";
//	}
//	
//	@RequestMapping(path = "/deleteProduct/{id}")
//	public String deleteProductById(Model model, @PathVariable("id") Long id) 
//							throws RecordNotFoundException 
//	{
//		service.deleteProductById(id);
//		return "redirect:/products";
//	}
//
//	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
//	public String createOrUpdateProduct(Product product) 
//	{
//		service.createOrUpdateProduct(product);
//		return "redirect:/products";
//	}
//}
