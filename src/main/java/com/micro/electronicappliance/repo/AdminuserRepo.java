package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.AdministrativeUser;


public interface AdminuserRepo {
	   public AdministrativeUser findById(int id);
	   public List<AdministrativeUser> findAll();
	   public AdministrativeUser save(AdministrativeUser administrativeUser);
	   public AdministrativeUser update(AdministrativeUser administrativeUser);
	   public void delete(int id) ;
}

