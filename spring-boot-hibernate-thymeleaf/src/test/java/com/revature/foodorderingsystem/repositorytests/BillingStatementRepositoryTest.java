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
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.repository.BillingStatementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
public class BillingStatementRepositoryTest {
	
	@Autowired
	private BillingStatementRepository billingStatementRepo;
	
	private BillingStatement billStmt;
	
	@Before
	public void setUp() {
		billStmt = new BillingStatement(1, "Cafe", "Coffee", 1000, 4.23, 4230);
		billingStatementRepo.save(billStmt);
	}
	
	@After
	public void tearDown( ) {
		billingStatementRepo.delete(billStmt);;
	}
	
	@Test
	public void createBillingStatement() {
		BillingStatement b = new BillingStatement(2, "Diner", "Egg Sandwich", 2, 5.25, 10.50);
		BillingStatement result = billingStatementRepo.save(b);
		Assert.assertEquals(result.toString(), b.toString());
		billingStatementRepo.delete(result);
	}
	
	@Test
	public void getBillingStatementById() {
		BillingStatement result = billingStatementRepo.findById(billStmt.getId()).get();
		Assert.assertEquals(result.toString(), billStmt.toString());
	}
	
	@Test
	public void getAllBillingStatements() {
		List<BillingStatement> result = (List<BillingStatement>) billingStatementRepo.findAll();
		Assert.assertFalse(0 == result.size());
	}
	
	@Test
	public void updateBillingStatement() {
		billStmt.setRestaurantName("Diner");
		BillingStatement result = billingStatementRepo.save(billStmt);
		Assert.assertTrue("Diner" == result.getRestaurantName());
		Assert.assertEquals(result.toString(), billStmt.toString());
	}
	
	@Test
	public void deleteBillingStatement() {
		List<BillingStatement> allBillingStatements = (List<BillingStatement>) billingStatementRepo.findAll();
		int sizeBeforeDelete = allBillingStatements.size();
		billingStatementRepo.delete(billStmt);
		allBillingStatements = (List<BillingStatement>) billingStatementRepo.findAll();
		int sizeAfterDelete = allBillingStatements.size();
		Assert.assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
		}
}
