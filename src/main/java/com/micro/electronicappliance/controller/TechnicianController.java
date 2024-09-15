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
import com.micro.electronicappliance.model.Technician;
import com.micro.electronicappliance.service.TechnicianService;
import com.micro.electronicappliance.serviceimpl.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/tech")
public class TechnicianController {
@Autowired
private TechnicianService technicianService;

@Autowired
private EmailService emailService;

@PostMapping
public Technician register(@RequestBody Technician technician) {
	technicianService.saveTech(technician);
	return technician;
}

@PostMapping("/sendmail")
public ResponseEntity<String> sendEmail(@RequestBody TechnicianEmailRequest request) {
    try {
    	Technician technician = request.getTechnician();
        String password = request.getPassword();
        // Extract details from the request
        String recipientEmail = technician.getUsername();
        String name = technician.getTname();
        String pwd = password;
        
//        String winningPrice = Double.toString(  request.getProduct().getCurrentBiddingPrice());

        // Create email subject and body
        String subject = "Welcome to Stark Electronics ! Your Login Credentials";
//        String text = String.format("Dear %s,\n\nCongratulations! You have won the auction for the product '%s' with a winning bid of %s.\n\nThank you for participating!\n\nBest Regards,\n AAA Auction Team",winner, productName, winningPrice);
        String body = String.format("Dear %s,\n\n"
        	    + "Welcome to  Stark Electronics Customer Support Service !\n\n"
        	    + "We are excited to have you on board. To get you started, please find your login credentials below:\n\n"
        	    + "Username: %s \n\n"
        	    + "Temporary Password: %s \n\n"
        	    + "For your first login, please follow these steps:\n\n"
        	    + "1. Visit our website , Login with the attached credentials\n"
        	    + "2. Enter your username and temporary password.\n"
        	    + "3. You will be prompted to change your temporary password. Please choose a strong, secure password that you have not used before.\n\n"
        	    + "If you encounter any issues or need assistance, please do not hesitate to contact our IT support team at starkelectronics@itsupport.com or  +91 9087124365.\n\n"
        	    + "Once again, welcome to our Organization ! We look forward to working with you.\n\n"
        	    + "Best regards,\n\n"
        	    + "\n"
        	    + "Admin Team\n"
        	    + "Stark Electronics\n"
        	    + "",name,recipientEmail,pwd);
        // Send the email
        emailService.sendEmail(recipientEmail, subject, body);

        return ResponseEntity.ok("Email sent successfully");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
    }
}

@GetMapping("/all")
public List<Technician> getAll(){
	return technicianService.getAll();
}

@GetMapping("/{id}")
public Technician getById(@PathVariable int id) {

	return technicianService.getById(id);
}


@PutMapping("/sts")
public void sts(@RequestParam("techid") int techid,@RequestParam("sts") String sts) {
    technicianService.changests(techid, sts);
}
@PutMapping("/update/{id}")
public void update(@PathVariable int id, @RequestBody Technician technician) {
	technicianService.updateTech(id, technician);
}
@PutMapping("/pwd/{id}")
public void updatepwd(@PathVariable int id, @RequestParam("oldpwd") String oldpwd , @RequestParam("newpwd" ) String newpwd) {
	technicianService.updatePwd(id, oldpwd,newpwd);
}
}
