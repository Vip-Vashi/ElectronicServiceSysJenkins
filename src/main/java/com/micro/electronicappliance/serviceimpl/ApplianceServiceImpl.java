package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.electronicappliance.model.Appliances;
import com.micro.electronicappliance.repo.AppliancesRepo;
import com.micro.electronicappliance.service.AppliancesService;
@Service
public class ApplianceServiceImpl implements AppliancesService{
@Autowired
private AppliancesRepo repo;
	@Override
	public Appliances saveAppliance(Appliances appliance) {
		// TODO Auto-generated method stub
		return repo.save(appliance);
	}

	@Override
	public Appliances getApplianceById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Appliances> getAllAppliances() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteAppliance(int id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

}
