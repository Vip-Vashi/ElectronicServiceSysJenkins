package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.electronicappliance.model.AdministrativeUser;
import com.micro.electronicappliance.repo.AdminuserRepo;
import com.micro.electronicappliance.service.Adminservice;


@Service
public class AdminServiceImpl implements Adminservice {
 
    @Autowired
    private AdminuserRepo administrativeUserRepository;

	public AdministrativeUser saveAdministrativeUser(AdministrativeUser admin) {
		// TODO Auto-generated method stub
		return administrativeUserRepository.save(admin);
	}

	
	public AdministrativeUser getAdministrativeUserById(int adminid) {
		// TODO Auto-generated method stub
		 return administrativeUserRepository.findById(adminid);
	}

	
	public List<AdministrativeUser> getAllAdministrativeUsers() {
		// TODO Auto-generated method stub
		 return administrativeUserRepository.findAll();
	}

	
	public void deleteAdministrativeUser(int adminid) {
		// TODO Auto-generated method stub
		
	        if (administrativeUserRepository.findById(adminid) != null) {
	            administrativeUserRepository.delete(adminid);
	        } else {
	            throw new IllegalArgumentException("AdministrativeUser with ID " + adminid + " does not exist.");
	        }
	}

	
	public AdministrativeUser updateAdministrativeUser(AdministrativeUser admin) {
		// TODO Auto-generated method stub
		  if (administrativeUserRepository.findById(admin.getAdminUserId()) != null) {
	            return administrativeUserRepository.save(admin);
	        } else {
	            throw new IllegalArgumentException("AdministrativeUser with ID " + admin.getAdminUserId() + " does not exist.");
	        }
	}
 
	

}
