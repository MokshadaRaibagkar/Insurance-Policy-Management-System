package com.insurance.model;

public class Policy {
	private int policyId;
	private String customerName;
	private String policyType;
	private double premium;
	
	public Policy(int policyId, String customerName, String policyType, double premium ) {
		
		if (policyId <= 0) {
		        throw new IllegalArgumentException(
		            "Policy ID must be positive."
		        );
		    }
		 
		 if (customerName == null || customerName.trim().isEmpty()) {
		        throw new IllegalArgumentException(
		            "Customer name cannot be empty."
		        );
		    }
		 
		 if (policyType == null || policyType.trim().isEmpty()) {
		        throw new IllegalArgumentException(
		            "Policy type cannot be empty."
		        );
		    }
		 
		  if (premium <= 0) {
		        throw new IllegalArgumentException(
		            "Premium must be greater than zero."
		        );
		    }
		 
		this.policyId=policyId;
		this.customerName=customerName;
		this.policyType=policyType;
		this.premium=premium;
	}
	
	public int getPolicyId() {
		return policyId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getPolicyType() {
		return policyType;
	}
	
	public double getPremium() {
		return premium;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	
	public void setPolicyType(String policyType) {
	    this.policyType = policyType;
	}

	public void setPremium(double premium) {
	    this.premium = premium;
	}
	
	public void displayPolicy() {
		System.out.println("Policy ID: "+policyId);
		System.out.println("Customer Name: "+customerName);
		System.out.println("Policy Type: " + policyType);
	    System.out.println("Premium: " + premium);
	}
}
