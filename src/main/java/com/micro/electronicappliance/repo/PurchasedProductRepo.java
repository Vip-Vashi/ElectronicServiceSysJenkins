package com.micro.electronicappliance.repo;

import java.util.List;

import com.micro.electronicappliance.model.PurchasedProduct;

public interface PurchasedProductRepo {
	 PurchasedProduct findProductById(int productId);
	    List<PurchasedProduct> findAllProducts();
	    void deleteProductById(int productId);
	    public PurchasedProduct save(PurchasedProduct product) ;
}
