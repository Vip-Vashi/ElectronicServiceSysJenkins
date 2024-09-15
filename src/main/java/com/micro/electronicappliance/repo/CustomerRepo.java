package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.Customer;



public interface CustomerRepo {
	  public void delete(int id);
	  public List<Customer> findAll() ;
	  public Customer update(Customer user);
	  public Customer save(Customer user);
	  public Customer findById(int id);
}
