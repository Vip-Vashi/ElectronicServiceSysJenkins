package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.micro.electronicappliance.model.ServiceRequest;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.repo.RequestRepo;
import com.micro.electronicappliance.repo.TechnicianRepo;
import com.micro.electronicappliance.service.ServiceReqService;
@Service
public class ServiceReqServiceImpl implements ServiceReqService{
@Autowired
private RequestRepo repo;

@Autowired
private TechnicianRepo technicianRepo;
	@Override
	public void save(ServiceRequest serviceRequest) {
		repo.save(serviceRequest);
		
	}

	@Override
	public ServiceRequest findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<ServiceRequest> findAll() {
				return repo.findAll();
	}

	@Override
	public void update(ServiceRequest serviceRequest) {
		repo.update(serviceRequest);
	}

	@Override
	public void delete(int id) {
		repo.delete(id);
	}
public void assignTech( @RequestParam int req,int tech) {
		 ServiceRequest request = repo.findById(req);
		 request.setServicests("Assigned");
		 Technician technician = technicianRepo.findById(tech);
		 request.setTechnician(technician);
		 repo.update(request);
		
	}

@Override
public void changests(int reqid, String sts) {
	
	ServiceRequest request = repo.findById(reqid);
	request.setServicests(sts);
	repo.update(request);
	
}

@Override
public void rating(int reqid, String rating, String feedback) {
	ServiceRequest request = repo.findById(reqid);
	request.setFeedback(feedback);
	request.setRating(rating);
	repo.update(request);
}

@Override
public void changependingsts(int reqid, String sts, String remarks) {
	ServiceRequest request = repo.findById(reqid);
	request.setServicests(sts);
	request.setRemark(remarks);
	repo.update(request);
	
}

}
