package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.repo.CustomerRepo;
import com.micro.electronicappliance.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerRepo repo;
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Override
	public Customer saveCustomer(Customer user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return  repo.save(user);
	}

	@Override
	public Customer getCustomerById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return repo.findAll();
	}

	@Override
	public void deleteCustomerById(int id) {
		
		repo.delete(id);
	}

	@Override
	public Customer updateCustomer(int uid, Customer user) {
	
		if(repo.findById(uid)!=null) {
			user.setCid(uid);
			
			
			
			return repo.update(user);
		}
	
		return null;
	}

}
