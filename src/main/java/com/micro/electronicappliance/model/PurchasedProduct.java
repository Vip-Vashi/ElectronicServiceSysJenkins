package com.micro.electronicappliance.model;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Purchased_products")
public class PurchasedProduct {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int productId;
        private String serialnum;
        private LocalDate purchaseDate;
        private String branch;
        @Lob
        @Column(length = 104857600 ,name = "bill")
        private byte[] imageBlob;
        @ManyToOne
        @JoinColumn(name = "Appliance")
        private Appliances appliances;
        
        @ManyToOne
        @JoinColumn(name = "Customer_id")
        private Customer customer;

		public PurchasedProduct() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PurchasedProduct(int productId, String serialnum, LocalDate purchaseDate, String branch, byte[] imageBlob,
				Appliances appliances, Customer customer) {
			super();
			this.productId = productId;
			this.serialnum = serialnum;
			this.purchaseDate = purchaseDate;
			this.branch = branch;
			this.imageBlob = imageBlob;
			this.appliances = appliances;
			this.customer = customer;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getSerialnum() {
			return serialnum;
		}

		public void setSerialnum(String serialnum) {
			this.serialnum = serialnum;
		}

		public LocalDate getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(LocalDate purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public byte[] getImageBlob() {
			return imageBlob;
		}

		public void setImageBlob(byte[] imageBlob) {
			this.imageBlob = imageBlob;
		}

		public Appliances getAppliances() {
			return appliances;
		}

		public void setAppliances(Appliances appliances) {
			this.appliances = appliances;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "PurchasedProduct [productId=" + productId + ", serialnum=" + serialnum + ", purchaseDate="
					+ purchaseDate + ", branch=" + branch + ", imageBlob=" + Arrays.toString(imageBlob)
					+ ", appliances=" + appliances + ", customer=" + customer + "]";
		}
        
        
}
