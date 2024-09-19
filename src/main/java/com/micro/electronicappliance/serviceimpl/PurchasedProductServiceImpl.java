package com.micro.electronicappliance.serviceimpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.electronicappliance.model.PurchasedProduct;
import com.micro.electronicappliance.repo.PurchasedProductRepo;
import com.micro.electronicappliance.service.PurchasedProductService;
@Service
public class PurchasedProductServiceImpl implements PurchasedProductService {
@Autowired
PurchasedProductRepo repo;
	@Override
	public PurchasedProduct save(PurchasedProduct purchasedProduct) {
		
		return repo.save(purchasedProduct);
	}

	@Override
	public PurchasedProduct getById(int productId) {
		
		  PurchasedProduct result= repo.findProductById(productId);  
		  
		  return result;
	}

	@Override
	public List<PurchasedProduct> getAll() {
		
		return repo.findAllProducts();
	}

	@Override
	public void deleteById(int productId) {
		repo.deleteProductById(productId);		
	}

}
