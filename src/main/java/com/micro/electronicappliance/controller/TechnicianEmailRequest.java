package com.micro.electronicappliance.controller;

import com.micro.electronicappliance.model.Technician;

public class TechnicianEmailRequest {
	 private Technician technician;
	    private String password;
		public Technician getTechnician() {
			return technician;
		}
		public void setTechnician(Technician technician) {
			this.technician = technician;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
}
