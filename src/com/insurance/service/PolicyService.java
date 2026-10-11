package com.insurance.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.insurance.exception.DuplicatePolicyException;
import com.insurance.exception.InvalidPolicyException;
import com.insurance.exception.PolicyNotFoundException;


import com.insurance.model.Policy;

public class PolicyService {
	private List<Policy> policies=new ArrayList<>();
	
	//add a policy preventing duplicate IDs
	public void addPolicy(Policy policy) {
		
		if(policy==null) {
			throw new InvalidPolicyException("Policy cannot be null.");
		}
		
		if(findPolicyById(policy.getPolicyId()) != null) {
			throw new DuplicatePolicyException("Policy ID already exists: "+policy.getPolicyId());
		}
		
		if(policy.getPremium()<=0) {
			throw new InvalidPolicyException("Premium must be greater than zero");
		}
		
		policies.add(policy);
		System.out.println("Policy added successfully!");
	}
	
	//Search for a policy by ID
	public Policy findPolicyById(int policyId) {
		for(Policy policy:policies) {
			if(policy.getPolicyId()==policyId) {
				return policy;
			}
		}
		return null;
	}
	
	//Display a policy
	public void searchPolicy(int policyId) {
		
		Policy policy=findPolicyById(policyId);
		
		if(policy==null) {
			throw new PolicyNotFoundException(
		            "Policy not found: " + policyId
		        );
		}else {
			policy.displayPolicy();
		}
	}
	
	//Update an existing policy
	public void updatePolicy( 
			int policyId,
            String customerName,
            String policyType,
            double premium) {
		Policy policy=findPolicyById(policyId);
		if(policy==null) {
			 throw new PolicyNotFoundException(
			            "Policy not found: " + policyId
			        );
		}
		if(customerName==null || customerName.trim().isEmpty()
				|| policyType == null || policyType.trim().isEmpty()
				|| premium<= 0) {
			 throw new InvalidPolicyException(
			            "Invalid policy details."
			        );
		}
		
		policy.setCustomerName(customerName);
		policy.setPolicyType(policyType);
		policy.setPremium(premium);
		
		System.out.println("Policy updated successfully");
	}
	
	//Cancel a policy by removing it from the current in-memory list
	public void cancelPolicy(int policyId) {
		Iterator<Policy> iterator=policies.iterator();
		
		while(iterator.hasNext()) {
			Policy policy =iterator.next();
			
			if(policy.getPolicyId()==policyId) {
				iterator.remove();
				System.out.println("Policy cancelled successfully.");
				return;
			}
		}
		 throw new PolicyNotFoundException(
			        "Policy not found: " + policyId
			    );
	}
	
	//Display all policies
	public void viewAllPolicies() {
		if(policies.isEmpty()) {
			System.out.println("No policies found");
			return;
		}
		
		for (Policy policy:policies) {
			policy.displayPolicy();
			System.out.println("-------------------");
		}
	}
}
