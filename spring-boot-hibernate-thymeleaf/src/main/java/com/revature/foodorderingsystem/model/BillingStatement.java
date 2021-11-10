package com.revature.foodorderingsystem.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "billingstatement")
public class BillingStatement implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "billingstatement_id")
	private long id;

	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="unit_price")
	private double unitPrice;

	@Column(name = "extended_price")
	private double extendedPrice;


	public BillingStatement() {
		super();
	}


	public BillingStatement(long id, String restaurantName, String productName, int quantity, double unitPrice,
			double extendedPrice) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.extendedPrice = extendedPrice;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public double getExtendedPrice() {
		return extendedPrice;
	}


	public void setExtendedPrice(double extendedPrice) {
		this.extendedPrice = extendedPrice;
	}


	
	
}


//
//@Id
//@GeneratedValue(strategy = GenerationType.TABLE)
//@Column(name = "billingstatement_id")
//public long getBillingStatementId() {
//	return billingStatementId;
//}
//
////public int getBillingStatementId() {
////	return billingStatementId;
////}
//
//public void setBillingStatementId(long billingStatementId) {
//	this.billingStatementId = billingStatementId;
//}
//
//public Customer getCustomer() {
//	return customer;
//}
//
//public void setCustomer(Customer customer) {
//	this.customer = customer;
//}
//
//public Restaurant getRestaurant() {
//	return restaurant;
//}
//
//public void setRestaurant(Restaurant restaurant) {
//	this.restaurant = restaurant;
//}
//
////public List<ListItem> getListItems() {
////	return listItems;
////}
////
////public void setListItems(List<ListItem> listItems) {
////	this.listItems = listItems;
////}
//
//public Date getSubmitDate() {
//	return submitDate;
//}
//
//public void setSubmitDate(Date submitDate) {
//	this.submitDate = submitDate;
//}
//
//public double getSubTotal() {
//	return subTotal;
//}
//
//public void setSubTotal(double subTotal) {
//	this.subTotal = subTotal;
//}
//
//public double getTax() {
//	return tax;
//}
//
//public void setTax(double tax) {
//	this.tax = tax;
//}
//
//public double getTotal() {
//	return total;
//}
//
//public void setTotal(double total) {
//	this.total = total;
//}
//
//@OneToMany(mappedBy = "billingStatement")
//public Set<ListItem> getListItems() {
//	return listItems;
//}
//
//public void setListItems(Set<ListItem> listItems) {
//	this.listItems = listItems;
//}
//
////@Override
////public String toString() {
////	return "BillingStatement [billingStatementId=" + billingStatementId + ", customer=" + customer + ", restaurant="
////			+ restaurant + ", listItems=" + listItems + ", submitDate=" + submitDate + ", subTotal=" + subTotal
////			+ ", tax=" + tax + ", total=" + total + "]";
////}
////
//
//


//
//package com.revature.foodorderingsystem.model;
//
//import java.sql.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "billingstatement")
//public class BillingStatement {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	@Column(name = "billingstatement_id")
//	private long id;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "restaurant_id")
//	private Restaurant restaurant;
//	
//	@Column(name = "submitDate")
//	private Date submitDate;
//	@Column(name = "sub_total")
//	private double subTotal;
//	@Column(name = "tax")
//	private double tax;
//	@Column(name = "total")
//	private double total;
//
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "billingStatement")
//	private Set<ListItem> listItems = new HashSet<ListItem>();
//
//	public BillingStatement() {
//		super();
//	}
//
//	public BillingStatement(Date submitDate, double subTotal, double tax, double total) {
//		super();
//		// this.billingStatementId = billingStatementId;
////		this.customer = customer;
////		this.restaurant = restaurant;
//		// this.listItems = listItems;
//		this.submitDate = submitDate;
//		this.subTotal = subTotal;
//		this.tax = tax;
//		this.total = total;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setBillingStatementId(long id) {
//		this.id = id;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
//
//	public Date getSubmitDate() {
//		return submitDate;
//	}
//
//	public void setSubmitDate(Date submitDate) {
//		this.submitDate = submitDate;
//	}
//
//	public double getSubTotal() {
//		return subTotal;
//	}
//
//	public void setSubTotal(double subTotal) {
//		this.subTotal = subTotal;
//	}
//
//	public double getTax() {
//		return tax;
//	}
//
//	public void setTax(double tax) {
//		this.tax = tax;
//	}
//
//	public double getTotal() {
//		return total;
//	}
//
//	public void setTotal(double total) {
//		this.total = total;
//	}
//
//	public Set<ListItem> getListItems() {
//		return listItems;
//	}
//
//	public void setListItems(Set<ListItem> listItems) {
//		this.listItems = listItems;
//	}
//
//	
//}
//
//
//
//
//
//
//
////
////@Id
////@GeneratedValue(strategy = GenerationType.TABLE)
////@Column(name = "billingstatement_id")
////public long getBillingStatementId() {
////	return billingStatementId;
////}
////
//////public int getBillingStatementId() {
//////	return billingStatementId;
//////}
////
////public void setBillingStatementId(long billingStatementId) {
////	this.billingStatementId = billingStatementId;
////}
////
////public Customer getCustomer() {
////	return customer;
////}
////
////public void setCustomer(Customer customer) {
////	this.customer = customer;
////}
////
////public Restaurant getRestaurant() {
////	return restaurant;
////}
////
////public void setRestaurant(Restaurant restaurant) {
////	this.restaurant = restaurant;
////}
////
//////public List<ListItem> getListItems() {
//////	return listItems;
//////}
//////
//////public void setListItems(List<ListItem> listItems) {
//////	this.listItems = listItems;
//////}
////
////public Date getSubmitDate() {
////	return submitDate;
////}
////
////public void setSubmitDate(Date submitDate) {
////	this.submitDate = submitDate;
////}
////
////public double getSubTotal() {
////	return subTotal;
////}
////
////public void setSubTotal(double subTotal) {
////	this.subTotal = subTotal;
////}
////
////public double getTax() {
////	return tax;
////}
////
////public void setTax(double tax) {
////	this.tax = tax;
////}
////
////public double getTotal() {
////	return total;
////}
////
////public void setTotal(double total) {
////	this.total = total;
////}
////
////@OneToMany(mappedBy = "billingStatement")
////public Set<ListItem> getListItems() {
////	return listItems;
////}
////
////public void setListItems(Set<ListItem> listItems) {
////	this.listItems = listItems;
////}
////
//////@Override
//////public String toString() {
//////	return "BillingStatement [billingStatementId=" + billingStatementId + ", customer=" + customer + ", restaurant="
//////			+ restaurant + ", listItems=" + listItems + ", submitDate=" + submitDate + ", subTotal=" + subTotal
//////			+ ", tax=" + tax + ", total=" + total + "]";
//////}
//////
////
////
//
