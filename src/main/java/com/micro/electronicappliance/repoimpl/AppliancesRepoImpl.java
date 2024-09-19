package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.electronicappliance.model.Appliances;
import com.micro.electronicappliance.repo.AppliancesRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AppliancesRepoImpl implements AppliancesRepo{
@Autowired
private EntityManager entityManager;
	@Override
	public Appliances save(Appliances appliance) {
		entityManager.persist(appliance);
        return appliance;
		
	}

	@Override
	public Appliances findById(int id) {
		
		return entityManager.find(Appliances.class, id);
	}

	@Override
	public List<Appliances> findAll() {
		
		return entityManager.createQuery("Select a FROM Appliances a", Appliances.class).getResultList();
	}

	@Override
	public void delete(int id) {
		   Appliances appliance = findById(id);
	        if (appliance != null) {
	            entityManager.remove(appliance);
	        }
		
	}

	
}
