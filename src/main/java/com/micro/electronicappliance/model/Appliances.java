package com.micro.electronicappliance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Appliances")
public class Appliances {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int applianceid;
private String brand = "LG";
private String category;
private String productname;
private String model;
private double price;
public Appliances() {
	super();
	
}
public Appliances(int applianceid, String brand, String category, String productname, String model, double price) {
	super();
	this.applianceid = applianceid;
	this.brand = brand;
	this.category = category;
	this.productname = productname;
	this.model = model;
	this.price = price;
}
public int getApplianceid() {
	return applianceid;
}
public void setApplianceid(int applianceid) {
	this.applianceid = applianceid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Appliances [applianceid=" + applianceid + ", brand=" + brand + ", category=" + category + ", productname="
			+ productname + ", model=" + model + ", price=" + price + "]";
}


}
