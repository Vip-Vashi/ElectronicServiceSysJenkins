package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.repo.TechnicianRepo;
import com.micro.electronicappliance.service.TechnicianService;

@Service
public class TechnicianServiceImpl implements TechnicianService{
@Autowired
private TechnicianRepo repo;
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
public Technician saveTech(Technician tech) {
	// TODO Auto-generated method stub
	tech.setPassword(encoder.encode(tech.getPassword()));
	
	return  repo.save(tech);
}


public Technician getById(int id) {
	// TODO Auto-generated method stub
	return repo.findById(id);
}


public List<Technician> getAll() {
	// TODO Auto-generated method stub
	return repo.findAll();
}


public void deleteById(int id) {
	// TODO Auto-generated method stub
	repo.delete(id);
}


public Technician updateTech(int id, Technician tech) {
	// TODO Auto-generated method stub
	if(repo.findById(id)!=null) {
		tech.setTechId(id);
		
		
		
		return repo.update(tech);
	}

	return null;
}


public Technician updatePwd(int id, String oldpwd,String newpwd) {
	// TODO Auto-generated method stub
	Technician tech = repo.findById(id);
//	if(tech!=null &&  oldpwd.equals(tech.getPassword())) {
	if(tech!=null && encoder.matches(oldpwd, tech.getPassword())) {
		tech.setPassword(encoder.encode(newpwd));
		return repo.update(tech);
	}

	return null;
}


@Override
public void changests(int techid, String sts) {
	
	Technician technician = repo.findById(techid);
	technician.setStatus(sts);
	repo.update(technician);
	
}

}
