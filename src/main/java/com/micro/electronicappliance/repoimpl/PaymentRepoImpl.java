package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.electronicappliance.model.Payment;

import com.micro.electronicappliance.repo.PaymentRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PaymentRepoImpl implements PaymentRepo {
    @Autowired
    private EntityManager entityManager;
	@Override
	public Payment save(Payment payment) {
		
		entityManager.persist(payment);
		return payment;
	}

	@Override
	public Payment findById(int id) {
		
		return entityManager.find(Payment.class, id);
	}

	@Override
	public Payment update(Payment payment) {
	
		return entityManager.merge(payment);
	}

	@Override
	public List<Payment> findAll() {
		
		 return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();

	}

}
