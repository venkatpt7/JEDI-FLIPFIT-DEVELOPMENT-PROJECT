/**
 * 
 */
package com.flipkart.client;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.business.FlipFitGymOwnerOperations;
import com.flipkart.bean.FlipFitGym;
/**
 * 
 */
public class FlipfitGymOwnerMenu {
	FlipFitGymOwner gymOwner;
	FlipFitGymOwnerOperations flipfitGymOwnerOperations;

	Scanner in;
	FlipFitGym flipFitGym = new FlipFitGym("Gym1","Bellandur",5,500,false,1);
	FlipfitGymOwnerMenu(Scanner in){
		this.in=in;
	 gymOwner = new FlipFitGymOwner();
	 flipfitGymOwnerOperations = new FlipFitGymOwnerOperations();
	}
	public void gymOwnerRegistration(Scanner in) {
		System.out.println("\nEnter GymOwner Details: \n");
		System.out.println("Enter Email: ");
		gymOwner.setUserEmail(in.next());
		System.out.println("Enter Password: ");
		gymOwner.setUserPassword(in.next());
		gymOwner.setUserRole("GymOwner");
		System.out.println("Enter Name: ");
		gymOwner.setUserName(in.next());
		System.out.println("Enter Phone Number: ");
		gymOwner.setUserMobile(in.next());
		System.out.println("Enter PAN: ");
		gymOwner.setPanNumber(in.next());
		System.out.println("Enter Aadhaar: ");
		gymOwner.setAdharNumber(in.next());

	 //need to add it to db and get the confirmation
	}
    public void login(String email,String password) {
        // Validate credentials
        if (flipfitGymOwnerOperations.validateCreds(email, password)) {
            System.out.println("Login successful!");
            gymOwnerMenu(email);
        } else {
            System.out.println("Invalid email or password.");
        }
    }

	public void editProfile(String email) {
		System.out.println("Enter Details: ");
		System.out.println("Enter Email: ");
		gymOwner.setUserEmail(in.next());
		System.out.println("Enter Password: ");
		gymOwner.setUserPassword(in.next());
		gymOwner.setUserRole("GymOwner");
		System.out.println("Enter Name: ");
		gymOwner.setUserName(in.next());
		System.out.println("Enter Phone Number: ");
		gymOwner.setUserMobile(in.next());
		System.out.println("Enter PAN: ");
		gymOwner.setPanNumber(in.next());
		System.out.println("Enter Aadhaar: ");
		gymOwner.setAdharNumber(in.next());

		flipfitGymOwnerOperations.editProfile();
	}

	public void viewProfile( String email) {
		flipfitGymOwnerOperations.viewProfile();
	}

	public void addGym( String email) {
		flipfitGymOwnerOperations.addGym(flipFitGym);
	}

	public void editGym(String email) {
		flipfitGymOwnerOperations.editGym(flipFitGym);
	}

	public void getGymDetails(String email) {
		List<FlipFitGym> gymDetails = flipfitGymOwnerOperations.getGymDetail(email);
		for (FlipFitGym gym : gymDetails) {
			System.out.println(gym.toString());
		}
	}

	public void addSlot() {
		Slot slot = new Slot();
		System.out.println("Enter slot id");
		slot.setSlotId(Integer.valueOf(in.next()));
		System.out.println("Enter Gym id");
		slot.setGymtId(Integer.valueOf(in.next()));
		System.out.println("Enter Start time");
		slot.setStartTime(LocalTime.ofSecondOfDay(Integer.parseInt(in.next())));
		System.out.println("Enter capacity");
		slot.setCapacity(Integer.valueOf(in.next()));
		System.out.println("Enter available seats");
		slot.setAvailableSeats(Integer.valueOf(in.next()));
		flipfitGymOwnerOperations.addSlot(slot);
	}

	public void gymOwnerMenu(String email) {
		boolean recur = true;
		while (recur) {
			System.out.println("\nHere are the actions you can perform!");

			System.out.println("1. View Profile");
			System.out.println("2. Edit Profile");
			System.out.println("3. Add Gym");
			System.out.println("4. Edit Gym");
			System.out.println("5. Add Slot");
			System.out.println("6. View All Gym Details");
			System.out.println("7. LogOut\n");

			System.out.println("Enter Your Choice: " );

			System.out.println("______________________________________________________________\n");
			int choice=in.nextInt();
			switch (choice) {
			case 1:
				viewProfile( email);
				break;
			case 2:
				editProfile(email);
				break;
			case 3:
				addGym(email);
				break;
			case 4:
				editGym(email);
				break;
			case 5:
				addSlot();
				break;
			case 6:
				getGymDetails(email);
				break;
			case 7:
				recur = false;
				break;
			default:
				System.out.println("Invalid Choice!");
			}
			if (!recur) {
				gymOwner = new FlipFitGymOwner();
				//boolean logOutSuccess = userBusiness.logout(gymOwner);
//				if (logOutSuccess)
//					System.out.println("Logged Out Successfully!");
//				else
					System.out.println("Logged Out Successfully!");
			}
		}

	}
}
