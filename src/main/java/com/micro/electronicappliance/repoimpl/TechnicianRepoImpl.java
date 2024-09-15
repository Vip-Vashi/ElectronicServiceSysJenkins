package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.repo.TechnicianRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TechnicianRepoImpl implements TechnicianRepo{
	  @PersistenceContext
	    private EntityManager entityManager;
	@Override
	public void delete(int id) {
		Technician technician = findById(id);
		if(technician!=null) {
			entityManager.remove(technician);
		}
		
	}

	@Override
	public List<Technician> findAll() {

		 return entityManager.createQuery("SELECT u FROM Technician u", Technician.class).getResultList();
	}

	@Override
	public Technician update(Technician tech) {
		entityManager.merge(tech);
		return tech;
	}

	@Override
	public Technician save(Technician tech) {
		entityManager.persist(tech);
		return tech;
	}

	@Override
	public Technician findById(int id) {
		
		return entityManager.find(Technician.class, id);
	}

}
