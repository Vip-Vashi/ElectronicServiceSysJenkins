package com.micro.electronicappliance.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.electronicappliance.model.Payment;
import com.micro.electronicappliance.repo.PaymentRepo;
import com.micro.electronicappliance.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {
	 @Autowired
	  private PaymentRepo paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(int id) {
		return paymentRepository.findById(id);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	
	@Override
	public Payment updatePayment(Payment payment) {
				return paymentRepository.update(payment);
	}

}
