package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;

import java.util.*;

/**
 * 
 */

public class FlipfitAdminClient {

	FlipfitAdminOperations flipfitAdminOperations = new FlipfitAdminOperations();

	List<FlipfitGymOwner> gymOwnerList;
	List<FlipfitGym> gymList;
	
	Scanner sc;
	
	FlipfitAdminClient(Scanner sc)
	{
		this.sc=sc;
		gymOwnerList = flipfitAdminOperations.getGymOwners();
		gymList = flipfitAdminOperations.getGym();
	}
	
	
	public void viewAllPendingGymOwnerRequests() {
		viewAllGymOwners(flipfitAdminOperations.viewAllPendingGymOwnerRequests());
	}
	public void viewAllPendingGymRequests() {
		viewAllGyms(flipfitAdminOperations.viewAllPendingGymRequests());
	}
	
	public void handleGymOwnerRequest() {
		System.out.println("Enter gym owner id: ");
		flipfitAdminOperations.approveGymOwnerRequest(sc.next());
	}
	
	public void handleGymRequest() {
		System.out.println("Enter gym Id: ");
		flipfitAdminOperations.approveGymRequest(sc.next());
	}

	
	

	public void adminOptions() throws Exception {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		while (true) {
			System.out.println("1. View pending Gym Owner Requests");
			System.out.println("2. View pending Gym Requests");
			System.out.println("3. Approve Gym Owner Request");
			System.out.println("4. Approve Gym Request");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			
		
			case 1:
				viewAllPendingGymOwnerRequests();
				break;
				
			case 2:
				viewAllPendingGymRequests();
				break;
		
			case 3:
				handleGymOwnerRequest();
				break;
				
			case 4:
				handleGymRequest();
				break;
				
			case 5:
                System.out.println("Exiting...");
                return; 	
				
			
			default:
				System.out.println("Please check the option you have entered");
			}
		}
}
			
	
	
}
