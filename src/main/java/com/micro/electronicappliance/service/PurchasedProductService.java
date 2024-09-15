package com.micro.electronicappliance.service;

import java.util.List;

import com.micro.electronicappliance.model.PurchasedProduct;

public interface PurchasedProductService {
	PurchasedProduct save(PurchasedProduct purchasedProduct);
    PurchasedProduct getById(int productId);
    List<PurchasedProduct> getAll();
    void deleteById(int productId);
}
