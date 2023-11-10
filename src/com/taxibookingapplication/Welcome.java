package com.taxibookingapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Welcome {

	public void start() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("WELCOME TO CALL TAXI SERVICES");
		System.out.println("-----------------------------------------------------------------------------------");
		DataStorage.pickuptimetem.add(0);
		DataStorage.droptimetem.add(0);
		while(true) {

			System.out.println("Enter 1 to Book the Taxi");
			System.out.println("Enter 2 to View the Details");
			System.out.println("Enter 3 to Cancel the Service");
			System.out.println("-----------------------------------------------------------------------------------");
			int userchoice = Integer.parseInt(br.readLine().trim());
			System.out.println("-----------------------------------------------------------------------------------");
			switch(userchoice) {
			case 1:
				Booking.TaxiBooking();
				break;
			case 2:
				ViewDetails.View();
				break;
			case 3:
				System.out.println("THANKS FOR VISITING THE CALL TAXI SERVICES");
				System.out.println("-----------------------------------------------------------------------------------");
				return;
			}
		}
	}
}
