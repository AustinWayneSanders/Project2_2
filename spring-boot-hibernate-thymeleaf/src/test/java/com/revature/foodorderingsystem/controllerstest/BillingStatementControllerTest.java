package com.revature.foodorderingsystem.controllerstest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foodorderingsystem.configuration.TestConfiguration;
import com.revature.foodorderingsystem.controller.BillingStatementController;
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.service.BillingStatementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BillingStatementControllerTest {

	@Mock
	private BillingStatementService service;
    @Autowired
    @InjectMocks
    private BillingStatementController controller;
    
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testGetAllBillingStatements() throws Exception {
		List<BillingStatement> stmts = new ArrayList<>();
		BillingStatement b = new BillingStatement(0, "IP3", "Cheese Pizza", 2, 15.08, 30.16);
		stmts.add(b);
		when(service.getAllBillingStatements()).thenReturn(stmts);
		List<BillingStatement> result = controller.getAllBillingStatements();
		Assert.assertNotNull(result);
		System.out.println(result.size() + "     " + stmts.size());
		Assert.assertTrue(stmts.size() == result.size());
		for (int i = 0; i < stmts.size(); i++) {
			Assert.assertEquals(stmts.get(i).toString(), result.get(i).toString());
		}
	}
}
