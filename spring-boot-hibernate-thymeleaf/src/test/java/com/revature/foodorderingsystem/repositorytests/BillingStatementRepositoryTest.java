//package com.revature.foodorderingsystem.repositorytests;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.revature.foodorderingsystem.configuration.TestConfiguration;
//import com.revature.foodorderingsystem.model.BillingStatement;
//import com.revature.foodorderingsystem.repository.BillingStatementRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//@DataJpaTest
//@Rollback(false)
//public class BillingStatementRepositoryTest {
//	
//	@Autowired
//	private BillingStatementRepository billingStatementRepo;
//	private BillingStatement billStmt = new BillingStatement(1, "Cafe", "Coffee", 1000, 4.23, 4230);
//	
//	@Before
//	public void setUpBeforeClass() {
//		billingStatementRepo.save(billStmt);
//	}
//
//	@Test
//	public void createBillingStatement() {
//		BillingStatement b = new BillingStatement(2, "Diner", "Egg Sandwich", 2, 5.25, 10.50);
//		BillingStatement result = billingStatementRepo.save(b);
//		Assert.assertNotNull(result);
//		Assert.assertEquals(result.getRestaurantName(), b.getRestaurantName());
//		Assert.assertEquals(result.getProductName(), b.getProductName());
//		Assert.assertTrue(result.getQuantity() == b.getQuantity());
//		Assert.assertTrue(result.getUnitPrice() == b.getUnitPrice());
//		Assert.assertTrue(result.getExtendedPrice() == b.getExtendedPrice());
//		billingStatementRepo.delete(result);
//	}
//	
//	@Test
//	public void getBillingStatementById() {
//		BillingStatement result = billingStatementRepo.findById(billStmt.getId()).get();
//		Assert.assertNotNull(result);
//		Assert.assertEquals(result.getRestaurantName(), billStmt.getRestaurantName());
//		Assert.assertEquals(result.getProductName(), billStmt.getProductName());
//		Assert.assertTrue(result.getQuantity() == billStmt.getQuantity());
//		Assert.assertTrue(result.getUnitPrice() == billStmt.getUnitPrice());
//		Assert.assertTrue(result.getExtendedPrice() == billStmt.getExtendedPrice());
//	}
//	
//	@Test
//	public void getAllBillingStatements() {
//		List<BillingStatement> result = (List<BillingStatement>) billingStatementRepo.findAll();
//		Assert.assertFalse(0 == result.size());
//	}
//	
//	@Test
//	public void updateBillingStatement() {
//		billStmt.setRestaurantName("Diner");
//		BillingStatement result = billingStatementRepo.save(billStmt);
//		Assert.assertNotNull(result);
//		Assert.assertEquals(result.toString(), billStmt.toString());
//	}
//	
//	@Test
//	public void deleteBillingStatement() {
//		BillingStatement b = new BillingStatement(2, "Diner", "Egg Sandwich", 2, 5.25, 10.50);
//		BillingStatement result = billingStatementRepo.save(b);
//		List<BillingStatement> allBillingStatements = (List<BillingStatement>) billingStatementRepo.findAll();
//		int sizeBeforeDelete = allBillingStatements.size();
//		billingStatementRepo.delete(result);
//		allBillingStatements = (List<BillingStatement>) billingStatementRepo.findAll();
//		int sizeAfterDelete = allBillingStatements.size();
//		Assert.assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
//	}
//}
