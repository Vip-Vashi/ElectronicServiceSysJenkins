package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.Payment;

public interface PaymentRepo {

	Payment save(Payment payment);

	Payment findById(int id);

	Payment update(Payment payment);

	List<Payment> findAll();

}
