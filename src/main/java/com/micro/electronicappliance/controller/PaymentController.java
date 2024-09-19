package com.micro.electronicappliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.electronicappliance.model.Payment;
import com.micro.electronicappliance.model.ServiceRequest;
import com.micro.electronicappliance.service.PaymentService;
import com.micro.electronicappliance.service.ServiceReqService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
@Autowired
private PaymentService service;
@Autowired
private ServiceReqService reqService;
@PostMapping
public ResponseEntity<Payment> createPayment(@RequestParam("reqid") int reqid , @RequestParam("servicecharge") int servicecharge,
		@RequestParam("sparepartcharge") int sparepartcharge,@RequestParam("billamt") int billamt,
		@RequestParam("status") String status
	) {
	    
	   ServiceRequest request = reqService.findById(reqid);
	   Payment payment = new Payment();
	   payment.setRequest(request);
	   payment.setServicecharge(servicecharge);
	   payment.setSparepartcharge(sparepartcharge);
	   payment.setBillamt(billamt);
	   payment.setStatus(status);
	   service.savePayment(payment);

    return new ResponseEntity<>(payment, HttpStatus.CREATED);
}

@GetMapping("/{id}")
public Payment getPaymentById(@PathVariable int id) {
    Payment payment = service.getPaymentById(id);
    return  payment  ;
}

@GetMapping("/all")
public ResponseEntity<List<Payment>> getAllPayments() {
    List<Payment> payments = service.getAllPayments();
    return ResponseEntity.ok(payments);
}

@PutMapping("/{id}")
public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
    if (service.getPaymentById(id)!= null) {
        service.updatePayment(payment);
        return ResponseEntity.ok(payment);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}

@PutMapping("/paysts")
public ResponseEntity<Payment> updatePaymentsts(@RequestParam("id") int id, @RequestParam("paysts") String sts) {
    if (service.getPaymentById(id)!= null) {
    	Payment payment = service.getPaymentById(id);
    	payment.setStatus(sts);
        service.updatePayment(payment);
        return ResponseEntity.ok(payment);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}

}
