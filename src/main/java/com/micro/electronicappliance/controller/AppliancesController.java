package com.micro.electronicappliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.electronicappliance.model.Appliances;
import com.micro.electronicappliance.service.AppliancesService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/appliances")
public class AppliancesController {
@Autowired
private AppliancesService service;

@PostMapping
public ResponseEntity<Appliances> saveAppliance(@RequestBody Appliances appliance) {
    Appliances savedAppliance = service.saveAppliance(appliance);
    return new ResponseEntity<>(savedAppliance, HttpStatus.CREATED);
}

// Get an Appliance by ID
@GetMapping("/{id}")
public ResponseEntity<Appliances> getApplianceById(@PathVariable int id) {
    Appliances appliance = service.getApplianceById(id);
    if (appliance != null) {
        return new ResponseEntity<>(appliance, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

// Get all Appliances
@GetMapping
public ResponseEntity<List<Appliances>> getAllAppliances() {
    List<Appliances> appliances = service.getAllAppliances();
    return new ResponseEntity<>(appliances, HttpStatus.OK);
}

}
