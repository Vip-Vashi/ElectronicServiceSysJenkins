package com.micro.electronicappliance.model;


import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Requests")
public class ServiceRequest {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int reqid;
	    private String servicetype;
	    private String issuedes;
	    private String productCondition;
	    private String servicests;
	    private LocalDate preferredDate;
	    private String feedback;
	    private String rating;
	    private String remark;
	    
	    @ManyToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "PurchasedAppliance_id")
	    private PurchasedProduct product;
	    
	   @ManyToOne(cascade = CascadeType.MERGE)
	   @JoinColumn(name = "Service Requester")
	   private Customer customer;
	    
	    
	   @ManyToOne(cascade = CascadeType.MERGE)
	   @JoinColumn(name = "Assigned Technician")
	   private Technician technician;


	public ServiceRequest() {
		super();
		
	}


	public ServiceRequest(int reqid, String servicetype, String issuedes, String productCondition, String servicests,
			LocalDate preferredDate, String feedback, PurchasedProduct product, Customer customer,
			Technician technician,String rating,String remark) {
		super();
		this.reqid = reqid;
		this.servicetype = servicetype;
		this.issuedes = issuedes;
		this.productCondition = productCondition;
		this.servicests = servicests;
		this.preferredDate = preferredDate;
		this.feedback = feedback;
		this.product = product;
		this.customer = customer;
		this.technician = technician;
		this.rating=rating;
		this.remark=remark;
	}


	public int getReqid() {
		return reqid;
	}


	public void setReqid(int reqid) {
		this.reqid = reqid;
	}


	public String getServicetype() {
		return servicetype;
	}


	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}


	public String getIssuedes() {
		return issuedes;
	}


	public void setIssuedes(String issuedes) {
		this.issuedes = issuedes;
	}


	public String getProductCondition() {
		return productCondition;
	}


	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}


	public String getServicests() {
		return servicests;
	}


	public void setServicests(String servicests) {
		this.servicests = servicests;
	}


	public LocalDate getPreferredDate() {
		return preferredDate;
	}


	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public PurchasedProduct getProduct() {
		return product;
	}


	public void setProduct(PurchasedProduct product) {
		this.product = product;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Technician getTechnician() {
		return technician;
	}


	public void setTechnician(Technician technician) {
		this.technician = technician;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "ServiceRequest [reqid=" + reqid + ", servicetype=" + servicetype + ", issuedes=" + issuedes
				+ ", productCondition=" + productCondition + ", servicests=" + servicests + ", preferredDate="
				+ preferredDate + ", feedback=" + feedback + ", rating=" + rating + ", remark=" + remark + ", product="
				+ product + ", customer=" + customer + ", technician=" + technician + "]";
	}


	   
}
