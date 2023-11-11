package com.taxibookingapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Welcome {

	public static List<Customer> customerList = new ArrayList<>();
	static ArrayList<Integer> pickuptimetem  = new ArrayList<>();
	static ArrayList<Integer> droptimetem  = new ArrayList<>();
	static int total_customer;
	static TreeMap<String,ArrayList<Customer>> taxiDetails = new TreeMap<>();
	static HashMap<String,Long> taxiTotalEarnings = new HashMap<>();
	
	public void start() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO CALL TAXI SERVICES");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Enter 1 to Book the Taxi");
			System.out.println("Enter 2 to View the Details");
			System.out.println("Enter 3 to Cancel the Service");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("Enter Your Choice : ");
			int userchoice = Integer.parseInt(br.readLine().trim());
			System.out.println("------------------------------------------------------------------------------------------");
			switch(userchoice) {
			case 1:
				Booking.TaxiBooking();
				break;
			case 2:
				ViewDetails.View();
				break;
			case 3:
				System.out.println("THANKS FOR VISITING THE CALL TAXI SERVICES");
				System.out.println("------------------------------------------------------------------------------------------");
				return;
			}
		}
	}
}
