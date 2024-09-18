package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.Payment;

public interface PaymentService {
	Payment savePayment(Payment payment);
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
    Payment updatePayment(Payment payment);
}
