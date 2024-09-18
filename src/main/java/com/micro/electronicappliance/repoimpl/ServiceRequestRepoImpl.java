package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.electronicappliance.model.ServiceRequest;
import com.micro.electronicappliance.repo.RequestRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ServiceRequestRepoImpl implements RequestRepo{
@Autowired
private EntityManager entityManager;
	
	public void save(ServiceRequest serviceRequest) {
	  entityManager.persist(serviceRequest);
		
	}

	@Override
	public ServiceRequest findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(ServiceRequest.class, id);
	}

	@Override
	public List<ServiceRequest> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT s FROM ServiceRequest s order by s.reqid desc",ServiceRequest.class).getResultList();
	}

	@Override
	public void update(ServiceRequest serviceRequest) {
		 entityManager.merge(serviceRequest);
		
	}
	
	
	@Override
	public void delete(int id) {
		  ServiceRequest serviceRequest = entityManager.find(ServiceRequest.class, id);
	        if (serviceRequest != null) {
	            entityManager.remove(serviceRequest);
	        }
		
	}

}
