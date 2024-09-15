package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.ServiceRequest;

public interface ServiceReqService {
	void save(ServiceRequest serviceRequest);
    ServiceRequest findById(int id);
    List<ServiceRequest> findAll();
    void update(ServiceRequest serviceRequest);
    void delete(int id);
    public void assignTech(int req,int tech);
	void changests(int reqid, String sts);
	void rating(int reqid, String rating, String feedback);
	void changependingsts(int reqid, String sts, String remarks);
}
