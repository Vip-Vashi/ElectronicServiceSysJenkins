package com.micro.electronicappliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.electronicappliance.model.AdministrativeUser;
import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.model.Login;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.service.Adminservice;
import com.micro.electronicappliance.service.CustomerService;
import com.micro.electronicappliance.service.TechnicianService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private CustomerService customerService;
@Autowired
private TechnicianService technicianService;

@Autowired
private Adminservice adminservice;
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

@PostMapping()
public Object login(@RequestBody Login login) {
	
	  String email = login.getEmail();
      String password = login.getPassword();

      List<AdministrativeUser> admins = adminservice.getAllAdministrativeUsers();
      for (AdministrativeUser admin : admins) {
          if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
              // Successful login for administrative user
              return admin; // Return the logged-in administrative user details
          }
      }
	 List<Customer> customers = customerService.getAllCustomers();
     for (Customer c : customers) {
         if (c.getEmail().equals(email) && encoder.matches(password, c.getPassword())) {
             // Successful login for customer
             return c; // Return the logged-in customer details
         }
     }
      List<Technician> technicians = technicianService.getAll();
      for (Technician t : technicians) {
          if (t.getUsername().equals(email) && encoder.matches(password, t.getPassword())) {
              // Successful login for customer
              return t; // Return the logged-in customer details
          }
      }
//      List<Technician> technicians = technicianService.getAll();
//      for (Technician t : technicians) {
//          if (t.getUsername().equals(email) && t.getPassword().equals(password)) {
//              // Successful login for customer
//              return t; // Return the logged-in customer details
//          }
//      }
//	
	
	return "Login Failed : Invalid Email or Password";
}
}
