//package com.revature.foodorderingsystem.model;
//
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
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
////import com.revature.foodorderingsystem.model.ListItem;
//
//@Entity
//@Table(name = "product")
//public class Product {
//
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="product_id")
//	private long id;
//	@Column(name="product_name")
//	private String productName;
//	@Column(name="unit_price")
//	private double unitPrice;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private Set<ListItem> listItems = new HashSet<ListItem>();
//	
////	@OneToMany(cascade = CascadeType.ALL)
////	@JoinColumn(name= "list_item_id")
////	private List<ListItem> listItems;
////	
//	public Product() {
//		super();
//	}
//
//	public Product(String productName, double unitPrice) {
//		super();
////		this.id = id;
//		this.productName = productName;
//		this.unitPrice = unitPrice;
////		this.listItems = listItems;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public double getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
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
//
//	
//	
//	
//	
//////	public void addItem(ListItem item) {
//////		this.listItems.add(item);
//////	}
////	
////
////	public long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public String getProductName() {
////		return productName;
////	}
////
////	public void setProductName(String productName) {
////		this.productName = productName;
////	}
////
////	public double getUnitPrice() {
////		return unitPrice;
////	}
////
////	public void setUnitPrice(double unitPrice) {
////		this.unitPrice = unitPrice;
////	}
////	
////
////	public Set<ListItem> getListItems(){
////		return listItems;
////		
////	}
////
////	public void setListItems(Set<ListItem> listItems) {
////		this.listItems = listItems;
////	}
////	
////	
////	public void addListItem(ListItem listItem) {
////		this.listItems.add(listItem);
////	}
//////	public List<ListItem> getListItems() {
//////		return listItems;
//////	}
////
//////	public void setListItems(List<ListItem> listItems) {
//////		this.listItems = listItems;
//////	}
////
//////	@Override
//////	public String toString() {
//////		return "Product [id=" + id + ", productName=" + productName + ", unitPrice=" + unitPrice + ", listItems="
//////				+ listItems + "]";
//////	}
//	
//	
//	
//	
//	
//}
