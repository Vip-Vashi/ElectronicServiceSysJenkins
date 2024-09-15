package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.Technician;

public interface TechnicianService {
	public Technician saveTech(Technician tech);
	public Technician getById(int id);
public void deleteById(int id) ;
public List<Technician> getAll();
public Technician updatePwd(int id, String oldpwd , String newpwd) ;
public Technician updateTech(int id, Technician tech) ;
public void changests(int techid, String sts);

}
