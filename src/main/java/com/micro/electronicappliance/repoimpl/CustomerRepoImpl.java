package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.repo.CustomerRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpl  implements CustomerRepo{

    @PersistenceContext
    private EntityManager entityManager;
	@Override
	public void delete(int id) {
		Customer customer = findById(id);
		if(customer!=null) {
			entityManager.remove(customer);
		}
		
	}

	@Override
	public List<Customer> findAll() {
		 return entityManager.createQuery("SELECT u FROM Customer u", Customer.class).getResultList();
	}

	@Override
	public Customer update(Customer user) {
		entityManager.merge(user);
		return user;
	}

	@Override
	public Customer save(Customer user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public Customer findById(int id) {
	  return entityManager.find(Customer.class, id);
	}

}
