package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.Appliances;

public interface AppliancesRepo {
	    Appliances save(Appliances appliance);
	    Appliances findById(int id);
	    List<Appliances> findAll();
	    void delete(int id);
}
