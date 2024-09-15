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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.micro.electronicappliance.model.Appliances;
import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.model.PurchasedProduct;
import com.micro.electronicappliance.repoimpl.PurchasedProductRepoImpl;
import com.micro.electronicappliance.service.AppliancesService;
import com.micro.electronicappliance.service.CustomerService;
import com.micro.electronicappliance.service.PurchasedProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class PurchasedProductController {
@Autowired
private PurchasedProductService service;
@Autowired
private AppliancesService appliancesService;
@Autowired

private CustomerService customerService;
@Autowired
	private PurchasedProductRepoImpl repoImpl;

@PostMapping
public ResponseEntity<String> registerProduct(
    @RequestParam("serialnum") String serialnum,
    @RequestParam("purchaseDate") String purchaseDate,
    @RequestParam("branch") String branch,
    @RequestParam("appliance") int applianceId,
//    @RequestParam("model") String model,
    @RequestParam("customer") int customerId,
    @RequestParam("imageBlob") MultipartFile imageBlob
) {
    try {
        LocalDate purchaseDateParsed = LocalDate.parse(purchaseDate);
        byte[] imageBlobBytes = imageBlob.getBytes();

        PurchasedProduct product = new PurchasedProduct();
        product.setSerialnum(serialnum);
        product.setPurchaseDate(purchaseDateParsed);
        product.setBranch(branch);
        product.setImageBlob(imageBlobBytes);
        // Set appliance and customer using their IDs
        // Assuming you have service methods to get these entities
        Appliances appliance = appliancesService.getApplianceById(applianceId);
        Customer customer = customerService.getCustomerById(customerId);
        product.setAppliances(appliance);
        product.setCustomer(customer);
        service.save(product);

        return ResponseEntity.ok("Product registration successful!");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product registration failed: " + e.getMessage());
    }
}




@GetMapping("/{id}")
public ResponseEntity<PurchasedProduct> getPurchasedProductById(@PathVariable int id) {
    PurchasedProduct product = service.getById(id);
    if (product != null) {
        return ResponseEntity.ok(product);
    } else {
        return ResponseEntity.notFound().build();
    }
}

//
@GetMapping("/serialnum/{snum}")
public ResponseEntity<PurchasedProduct> getPurchasedProduct(@PathVariable String snum) {
  	PurchasedProduct product = repoImpl.findProduct(snum);
    if (product != null) {
        return ResponseEntity.ok(product);
    } else {
        return ResponseEntity.notFound().build();
    }
}
@GetMapping
public ResponseEntity<List<PurchasedProduct>> getAllPurchasedProducts() {
    List<PurchasedProduct> products = service.getAll();
    return ResponseEntity.ok(products);
}
@DeleteMapping("/{id}")
public void deletePurchasedProduct(@PathVariable int id) {
    service.deleteById(id);
   
}
}
