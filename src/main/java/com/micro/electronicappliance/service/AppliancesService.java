package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.Appliances;

public interface AppliancesService {
	Appliances saveAppliance(Appliances appliance);
    Appliances getApplianceById(int id);
    List<Appliances> getAllAppliances();
    void deleteAppliance(int id);

}
