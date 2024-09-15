package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.Customer;


public interface CustomerService {
	Customer saveCustomer(Customer user);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void deleteCustomerById(int id);
    Customer updateCustomer(int uid, Customer user);
    
}
