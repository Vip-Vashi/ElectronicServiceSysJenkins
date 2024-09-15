package com.micro.electronicappliance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int cid;
	    private String name;
	    @Column(unique = true)
	    private String email;
	    private String password;
	    private String contact;
		private String role = "user";
	    @Column(length = 255)
		private String address;
	    private String pincode;
	    private String state;
	    private String district;
	    private String city;
	   
		public Customer() {
			super();
			
		}
		public Customer(int cid, String name, String email, String password, String contact, String role,
				String address, String pincode, String state, String district, String city) {
			super();
			this.cid = cid;
			this.name = name;
			this.email = email;
			this.password = password;
			this.contact = contact;
			this.role = role;
			this.address = address;
			this.pincode = pincode;
			this.state = state;
			this.district = district;
			this.city = city;
			
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		@Override
		public String toString() {
			return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", password=" + password
					+ ", contact=" + contact + ", role=" + role + ", address=" + address + ", pincode=" + pincode
					+ ", state=" + state + ", district=" + district + ", cityString=" + city + ", mobileString="
					+  "]";
		}
	    
	    
	    
	    
	    
	    
	    
	    

	
	
}
