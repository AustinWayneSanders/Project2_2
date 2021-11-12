//package com.revature.foodorderingsystem.controllerstest;
//
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.foodorderingsystem.controller.BillingStatementController;
//import com.revature.foodorderingsystem.model.BillingStatement;
//import com.revature.foodorderingsystem.service.BillingStatementService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@Rollback(false)
//public class BillingStatementControllerTest {
//
//	@Mock
//	private BillingStatementService service;
//	@Autowired
//	private MockMvc mvc;
//    @Autowired
//    @InjectMocks
//    private BillingStatementController controller;
//    private JacksonTester<BillingStatement> json; 
//    private BillingStatement b1 = new BillingStatement(1, "Cosmic Cantina", "Deluxe Veggie Burrito", 2, 8.99, 17.98);
//    private List<BillingStatement> mockStmts = new ArrayList<>();
//    
//    @Before
//    public void setUp() {
//    	MockitoAnnotations.initMocks(this);
//    	JacksonTester.initFields(this, new ObjectMapper());
//    	mvc = MockMvcBuilders.standaloneSetup(controller).build();
//        mockStmts.add(b1);
//    }
//	
//	@Test
//	public void contextLoads() throws Exception {
//		Assert.assertNotNull(controller);
//	}
//	
//	@Test
//	public void testGetAllBillingStatements() throws Exception {
//        when(service.getAllBillingStatements()).thenReturn(mockStmts);
//
//        MockHttpServletResponse response = mvc.perform(
//        		get("/billingStatements/billingStatements")
//        		.accept(MediaType.APPLICATION_JSON))
//        		.andReturn().getResponse();
//        Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
//	}
//	
//	@Test
//	public void testEditBillingStatementById() throws IOException, Exception {
//		when(service.getBillingStatementById((long) 1)).thenReturn(b1);
//		when(service.createOrUpdateBillingStatement(b1)).thenReturn(b1);
//		
//		MockHttpServletResponse response = mvc.perform(
//				put("/billingStatements/editBillingStatement/1").contentType(MediaType.APPLICATION_JSON).content(
//				json.write(new BillingStatement(1, "Cosmic Caninta", "Quesadilla", 3, 5.25, 15.75)).getJson()))
//				.andReturn().getResponse();
//
//	    Assert.assertTrue(response.getStatus() == HttpStatus.CREATED.value() || response.getStatus() == HttpStatus.OK.value());
//	}
//	
//	@Test
//	public void testCreateBillingStatment() throws IOException, Exception {
//		BillingStatement b2 = new BillingStatement(2, "IP3", "Cheese Pizza", 1, 16.50, 16.50);
//
//		doAnswer(invocation -> {
//			mockStmts.add(b2);
//			return b2;
//		}).when(service).createOrUpdateBillingStatement(b2);
//		
//		Assert.assertTrue(mockStmts.size() == 1);
//		
//		MockHttpServletResponse response = mvc.perform(
//				post("/billingStatements/createBillingStatement").contentType(MediaType.APPLICATION_JSON).content(
//				json.write(new BillingStatement(2, "IP3", "Cheese Pizza", 1, 16.50, 16.50)).getJson())).andReturn().getResponse();
//		
//		Assert.assertTrue(response.getStatus() == HttpStatus.CREATED.value() || response.getStatus() == HttpStatus.OK.value());
//		Assert.assertTrue(mockStmts.size() == 2);
//		
//		mockStmts.remove(b2);
//
//	}
//	
//	@Test
//	public void testDeleteBillingStatementById() throws Exception {
//		BillingStatement b2 = new BillingStatement(2, "IP3", "Cheese Pizza", 1, 16.50, 16.50);
//		mockStmts.add(b2);
//		
//		doAnswer(invocation -> {
//			mockStmts.remove(1);
//			return mockStmts;
//		}).when(service).deleteBillingStatementById((long) 2);
//		
//		Assert.assertTrue(mockStmts.size() == 2);
//		
//		MockHttpServletResponse response = mvc.perform(
//				 delete("/billingStatements/deleteBillingStatement/2")).andReturn().getResponse();
//		
//		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
//		Assert.assertTrue(mockStmts.size() == 1);
//	}
//}
