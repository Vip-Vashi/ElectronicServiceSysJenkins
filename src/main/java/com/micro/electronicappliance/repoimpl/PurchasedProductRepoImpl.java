package com.micro.electronicappliance.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.electronicappliance.model.Customer;
import com.micro.electronicappliance.model.PurchasedProduct;
import com.micro.electronicappliance.repo.PurchasedProductRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PurchasedProductRepoImpl implements PurchasedProductRepo{

	@Autowired
	private EntityManager entityManager;
	
	public PurchasedProduct save(PurchasedProduct product) {
		
		entityManager.persist(product);
		return product;
	}
	 public PurchasedProduct findProductById(int productId) {
	        return entityManager.find(PurchasedProduct.class, productId);
	    }
	 public List<PurchasedProduct> findAllProducts() {
		 return entityManager.createQuery("SELECT p FROM PurchasedProduct p", PurchasedProduct.class).getResultList();

	    }
	 
	 public PurchasedProduct findProduct(String snum) {
		 return entityManager.createQuery("SELECT p FROM PurchasedProduct p Where p.serialnum = :  snum", PurchasedProduct.class).setParameter("snum", snum).getSingleResult();

	    }
	 public void deleteProductById(int productId) {
	        PurchasedProduct product = entityManager.find(PurchasedProduct.class, productId);
	        if (product != null) {
	            entityManager.remove(product);
	        }
	    }
}
