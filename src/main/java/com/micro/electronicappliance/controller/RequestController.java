package com.micro.electronicappliance.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.model.PurchasedProduct;
import com.micro.electronicappliance.model.ServiceRequest;
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.service.CustomerService;
import com.micro.electronicappliance.service.PurchasedProductService;
import com.micro.electronicappliance.service.ServiceReqService;
import com.micro.electronicappliance.service.TechnicianService;
import com.micro.electronicappliance.serviceimpl.EmailService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/servicerequests")
public class RequestController {
	@Autowired
	private EmailService emailService;
	
@Autowired
private ServiceReqService service;
@Autowired 
private CustomerService customerService;

@Autowired
private PurchasedProductService productService;

@Autowired 
private TechnicianService technicianService;


@PostMapping
public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
    service.save(serviceRequest);
    return serviceRequest;
}
@GetMapping("/{id}")
public ResponseEntity<ServiceRequest> getServiceRequestById(@PathVariable int id) {
    ServiceRequest serviceRequest = service.findById(id);
  
    if (serviceRequest != null) {
        return ResponseEntity.ok(serviceRequest);
    } else {
        return ResponseEntity.notFound().build();
    }
}
@GetMapping
public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
    List<ServiceRequest> serviceRequests = service.findAll();
    return ResponseEntity.ok(serviceRequests);
}


@PutMapping("/{id}")
public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable int id, @RequestBody ServiceRequest serviceRequest) {
    ServiceRequest existingServiceRequest = service.findById(id);
    
    if (existingServiceRequest != null) {
        serviceRequest.setReqid(id); // Ensure the ID is preserved
        service.update(serviceRequest);
        return ResponseEntity.ok(serviceRequest);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@PutMapping("/assign")
public void assigntech(@RequestParam("reqid") int reqid,@RequestParam("techid") int techid) {
    service.assignTech(reqid, techid);
}


@PutMapping("/rating")
public void rating(@RequestParam("reqid") int reqid,@RequestParam("rating") String rating , @RequestParam("feedback") String feedback ) {
    service.rating(reqid, rating,feedback);
}
@DeleteMapping("/{id}")
public void deleteServiceRequest(@PathVariable int id) {
    ServiceRequest existingServiceRequest = service.findById(id);
    if (existingServiceRequest != null) {
       
       service.delete(id);
    } 
}
@PostMapping("/mail")
public ResponseEntity<String> sendEmail(@RequestBody ServiceRequest request) {
    try {
        // Extract details from the request
    	System.out.println(request);
        
        	int customerid	= request.getCustomer().getCid();
        	Customer customer = customerService.getCustomerById(customerid);
        	String recipientEmail =customer.getEmail();
            String name = customer.getName();
        int reqid = request.getReqid();
        System.out.println(recipientEmail);
        

        // Create email subject and body
        String subject = "Service Request Submission";
        String text = String.format("Dear customer  %s,\n\n Your Service Request has been submitted successfully!!. Your Request Id is : %d,You can track your request status by login to our website -> Go to  Track Request Status and Enter Request Id .\n\nThank you !\n\nBest Regards,\n Admin Team \n Stark Electronics",name,reqid);

        // Send the email
        emailService.sendEmail(recipientEmail, subject, text);

        return ResponseEntity.ok("Email sent successfully");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
    }
}

@PutMapping("/sts")
public void sts(@RequestParam("reqid") int reqid,@RequestParam("sts") String sts) {
    service.changests(reqid, sts);
}

@PutMapping("/stspending")
public void stspending(@RequestParam("reqid") int reqid,@RequestParam("sts") String sts , @RequestParam("remarks") String remarks) {
    service.changependingsts(reqid, sts,remarks);
}

@PutMapping("/edit/{id}")
public  ResponseEntity<String>  assignTech(
		
		    @RequestParam("servicetype") String servicetype,
		    @RequestParam("issuedes") String issuedes,
		    @RequestParam("productCondition") String productCondition,
		    @RequestParam("servicests") String servicests,
		    @RequestParam("feedback") String feedback,
		    @RequestParam("preferredDate") String preferredDate,
		    @RequestParam("product") int product,
		    @RequestParam("customer") int customer,
		    @RequestParam("technician") int technician
		){
        try {
        	
        	
        	LocalDate preferredvisitDate = LocalDate.parse(preferredDate);
        	PurchasedProduct prod = productService.getById(product);
        	Customer customerobj= customerService.getCustomerById(customer);
        	Technician tech = technicianService.getById(technician);
        	ServiceRequest serviceRequest = new ServiceRequest();
        	serviceRequest.setServicetype(servicetype);
        	serviceRequest.setFeedback(feedback);
        	serviceRequest.setIssuedes(issuedes);
        	serviceRequest.setPreferredDate(preferredvisitDate);
        	serviceRequest.setProductCondition(productCondition);
        	serviceRequest.setServicests(servicests);
        	serviceRequest.setCustomer(customerobj);
        	serviceRequest.setProduct(prod);
        	serviceRequest.setTechnician(tech);
        	
        	service.update(serviceRequest);
        	return ResponseEntity.ok("Update successful!!");
        }
         catch (Exception e) {
        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed: " + e.getMessage());
		}




           }

}

