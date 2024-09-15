package com.micro.electronicappliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.service.CustomerService;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customers")
public class CustomerController {
@Autowired
private CustomerService customerService;

BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
@PostMapping
public Customer register(@RequestBody Customer customer) {
	customerService.saveCustomer(customer);
	return customer;
}

@PostMapping("/check")
public String login(@RequestBody Customer customer) {
	 List<Customer> customers = customerService.getAllCustomers();
     for (Customer c : customers) {
         if (c.getEmail().equals(customer.getEmail()) && encoder.matches(customer.getPassword(), c.getPassword())) {
             // Successful login for customer
             return "Success"; // Return the logged-in customer details
         }
     }
	return "Failed";
}

@GetMapping("/all")
public List<Customer> getAll(){
	return customerService.getAllCustomers();
}


@GetMapping("/{id}")
public Customer getCustomerById(@PathVariable int id) {

	return customerService.getCustomerById(id);
}

@PutMapping("/update/{id}")
public void updateUser(@PathVariable int id, @RequestBody Customer user) {
	customerService.updateCustomer(id, user);
}



}
