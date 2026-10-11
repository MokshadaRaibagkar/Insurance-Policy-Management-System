package com.insurance;

import com.insurance.exception.DuplicatePolicyException;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.model.Policy;
import com.insurance.service.PolicyService;

public class Main {

	public static void main(String[] args) {
		 
		PolicyService service = new PolicyService();

		Policy p1 = new Policy(101, "Rahul", "Health", 12000.0);
		Policy p2 = new Policy(102, "Priya", "Life", 18000.0);

		service.addPolicy(p1);
		service.addPolicy(p2);

		// Test duplicate prevention
		try {
		    service.addPolicy(
		        new Policy(101, "Amit", "Health", 15000.0)
		    );
		} catch (DuplicatePolicyException e) {
		    System.out.println("Error: " + e.getMessage());
		}

		// Test searching
		System.out.println("\n--- Search ---");

		try {
		    service.searchPolicy(101);
		} catch (PolicyNotFoundException e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
        // Test updating a policy
        System.out.println("\n--- Update ---");
        service.updatePolicy(102, "Priya Sharma", "Life", 20000.0);
        service.searchPolicy(102);

        // Test canceling a policy
        System.out.println("\n--- Cancel ---");
        service.cancelPolicy(101);
        
     // Test canceling a policy that does not exist
        System.out.println("\n--- Test Invalid Cancellation ---");

        try {
            service.cancelPolicy(999);
        } catch (PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        

        // Display remaining policies
        System.out.println("\n--- All Policies ---");
        service.viewAllPolicies();

	}

}
