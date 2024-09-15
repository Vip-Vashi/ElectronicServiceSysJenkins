package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.Technician;

public interface TechnicianRepo {
	  public void delete(int id);
	  public List<Technician> findAll() ;
	  public Technician update(Technician tech);
	  public Technician save(Technician tech);
	  public Technician findById(int id);
}
