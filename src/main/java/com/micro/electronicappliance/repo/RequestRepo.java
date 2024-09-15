package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.ServiceRequest;

public interface RequestRepo {
	   void save(ServiceRequest serviceRequest);
	    ServiceRequest findById(int id);
	    List<ServiceRequest> findAll();
	    void update(ServiceRequest serviceRequest);
	    void delete(int id);
}
