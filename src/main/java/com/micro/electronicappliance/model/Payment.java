package com.micro.electronicappliance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int pid;
	    private int billamt;
	    private int servicecharge;
	    private int sparepartcharge;
	    private String status;
	    @OneToOne
	    private ServiceRequest request;
		public Payment() {
			super();
			
		}
		public Payment(int pid, int billamt, int servicecharge, int sparepartcharge, String status,
				ServiceRequest request) {
			super();
			this.pid = pid;
			this.billamt = billamt;
			this.servicecharge = servicecharge;
			this.sparepartcharge = sparepartcharge;
			this.status = status;
			this.request = request;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public int getBillamt() {
			return billamt;
		}
		public void setBillamt(int billamt) {
			this.billamt = billamt;
		}
		public int getServicecharge() {
			return servicecharge;
		}
		public void setServicecharge(int servicecharge) {
			this.servicecharge = servicecharge;
		}
		public int getSparepartcharge() {
			return sparepartcharge;
		}
		public void setSparepartcharge(int sparepartcharge) {
			this.sparepartcharge = sparepartcharge;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public ServiceRequest getRequest() {
			return request;
		}
		public void setRequest(ServiceRequest request) {
			this.request = request;
		}
		@Override
		public String toString() {
			return "Payment [pid=" + pid + ", billamt=" + billamt + ", servicecharge=" + servicecharge
					+ ", sparepartcharge=" + sparepartcharge + ", status=" + status + ", request=" + request + "]";
		}
	    
	    
}
