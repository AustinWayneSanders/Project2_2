//package com.revature.foodorderingsystem.servicetests;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.revature.foodorderingsystem.configuration.TestConfiguration;
//import com.revature.foodorderingsystem.exception.RecordNotFoundException;
//import com.revature.foodorderingsystem.model.BillingStatement;
//import com.revature.foodorderingsystem.repository.BillingStatementRepository;
//import com.revature.foodorderingsystem.service.BillingStatementService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//public class BillingStatementServiceTest {
//
//	@Mock
//    private BillingStatementRepository billStmtRepo;
//
//	private BillingStatement b1 = new BillingStatement(1, "Taco Truck", "Taco", 3, 4.25, 12.75);
//	private BillingStatement b2 = new BillingStatement(2, "Cosmic Cantina", "Veg Burrito", 1, 6.50, 6.50);
//    
//    @Autowired
//    @InjectMocks
//    BillingStatementService billStmtService;
//    
//    @Before
//    public void setUp() {
//    	MockitoAnnotations.initMocks(this);
//    }
//    
//    
//    @Test
//    public void testCreateOrUpdateBillingStatement() {
//    	// mocking billing statement repository method
//    	when(billStmtRepo.save(any(BillingStatement.class))).thenReturn(b1);
//    	
//    	// call createOrUpdateBillingStatement
//    	BillingStatement result = billStmtService.createOrUpdateBillingStatement(b1);
//    	
//    	// Assert expected results
//    	Assert.assertNotNull(result);
//        Assert.assertEquals(result.toString(), b1.toString());
//    }
//    
//    @Test
//    public void testGetAllBillingStatements() {
//    	//////////////////// Test for empty array when nothing in db //////////////////
//    	// mock repo method
//    	when((List<BillingStatement>) billStmtRepo.findAll()).thenReturn(new ArrayList<BillingStatement>());
//    	
//    	// call getAllBillingStatements
//        List<BillingStatement> result = billStmtService.getAllBillingStatements();
//        
//        // assert expected results
//        Assert.assertNotNull(result);
//        Assert.assertTrue(result.size() == 0);
//        
//        //////////////////// Test on non-empty db //////////////////// 	
//    	// build mock db & mock billing statement methods
//    	List<BillingStatement> billStmts = new ArrayList<BillingStatement>();
//    	
//    	// mocking billing statement repository method
//    	when(billStmtRepo.findAll()).thenReturn(billStmts);
//    	
//    	// call getAllBillingStatements
//    	result = billStmtService.getAllBillingStatements();
//   
//        // Assert expected results
//    	Assert.assertNotNull(result);
//    	Assert.assertTrue(result.size() == billStmts.size());
//    	for (int i = 0; i < result.size(); i++) {
//    		BillingStatement rb = result.get(i);
//    		BillingStatement b = billStmts.get(i);
//        	Assert.assertNotNull(result);
//            Assert.assertEquals(rb.toString(), b.toString());
//    	}
//    }
//    
//    @Test
//    public void testGetBillingStatementsById() {
//    	//////////////////// Test for exception on empty db ////////////////////
//    	try {
//			billStmtService.getBillingStatementById((long) 1);
//		} catch (RecordNotFoundException e) {
//			Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
//		}
//    	
//    	//////////////////// Test on non-empty db ////////////////////
//    	// mocking billings statement repository method
//        Optional<BillingStatement> b = Optional.of(b1);
//    	when(billStmtRepo.findById((long) 1)).thenReturn(b);
//    	b = Optional.of(b2);
//    	when(billStmtRepo.findById((long) 2)).thenReturn(b);
//    	
//    	// call getBillingStatementById
//    	BillingStatement result;
//    	try {
//		    result = billStmtService.getBillingStatementById(b1.getId());
//		    
//	    	// assert expected results
//	    	Assert.assertNotNull(result);
//            Assert.assertEquals(result.toString(), b1.toString());
//		} catch (RecordNotFoundException e) {
//			e.printStackTrace();
//		}
//    
//        //////////////////// Test on non-empty db for non-existent billing statement ////////////////////
//	    try {
//		    billStmtService.getBillingStatementById((long) 3);
//	    } catch (RecordNotFoundException e) {
//		    Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
//	    }
//    }
//    
//    @Test
//    public void testDeleteBillingStatementById() {
//    	//////////////////// Test on empty db ////////////////////
//    	try {
//			billStmtService.deleteBillingStatementById((long) 1);
//		} catch (RecordNotFoundException e) {
//			Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
//		}
//    	
//    	//////////////////// Test on non-empty db ///////////////////
//    	// mocking billing statement methods
//    	List<BillingStatement> billStmts = new ArrayList<BillingStatement>();
//    	billStmts.add(b1);
//    	billStmts.add(b2);
//    	
//    	// mocking repo methods
//      	doAnswer(invocation -> {
//      		billStmts.remove(b1);
//      		return null;
//      	}).when(billStmtRepo).deleteById((long) 1);
//      	
//      	// call deleteById
//      	try {
//      		billStmtService.deleteBillingStatementById((long) 1);
//      		
//      		// assert expected results
//      		Assert.assertFalse(billStmts.contains(b1));
//      	} catch (RecordNotFoundException e) {
//      		e.printStackTrace();
//      	}
//    	
//    	//////////////////// Test on non-empty db for non-existent billing statement ////////////////////
//      	try {
//      		billStmtService.deleteBillingStatementById((long) 1);
//      	} catch (RecordNotFoundException e) {
//      		Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
//      	}
//    }
//}
