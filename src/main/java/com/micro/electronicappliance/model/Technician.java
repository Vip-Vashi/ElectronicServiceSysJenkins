package com.micro.electronicappliance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TechId;
    private String role ="Technician";
    private String tname;
    private String contact;
    @Column(unique = true)
    private String username;
    private String password;
    private String domain;
    private String skill; //repair , installation ,HVAC,Electrical
    private String status;//Assigned ,Available,In Progress
    private String district;
    private String city;
    private String pincode;
    
    
	public Technician() {
		super();
		
	}
	
	

	
	public Technician(int techId, String role, String tname, String contact, String username, String password,
			String domain, String skill, String status, String district, String city, String pincode) {
		super();
		this.TechId = techId;
		this.role = role;
		this.tname = tname;
		this.contact = contact;
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.skill = skill;
		this.status = status;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
	}




	public int getTechId() {
		return TechId;
	}
	public void setTechId(int techId) {
		TechId = techId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getStatus() {
		return status;
	}
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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




	public String getPincode() {
		return pincode;
	}




	public void setPincode(String pincode) {
		this.pincode = pincode;
	}




	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Technician [TechId=" + TechId + ", role=" + role + ", tname=" + tname + ", contact=" + contact
				+ ", username=" + username + ", password=" + password + ", domain=" + domain + ", skill=" + skill
				+ ", status=" + status + ", district=" + district + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
    
}
