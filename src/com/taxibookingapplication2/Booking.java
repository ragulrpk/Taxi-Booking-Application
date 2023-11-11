package com.taxibookingapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Booking{

	public static void TaxiBooking() throws IOException
	{
		//to get input from the customer
		
		Welcome.total_customer++;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Customer Id : ");
		long customerID = Long.parseLong(br.readLine());
		System.out.print("Pick Point  : ");
		char pickUpPoint = br.readLine().charAt(0); 
		System.out.print("Drop Point  : ");
		char dropPoint = br.readLine().charAt(0);
		System.out.print("Pickup Time : ");
		int pickUpTime = Integer.parseInt(br.readLine());
		int dropTime = pickUpTime+Math.abs(dropPoint-pickUpPoint);
		int amount = 100+(((Math.abs(dropPoint-pickUpPoint)*15)-5)*10);

		Customer customer = new Customer(customerID,"", pickUpPoint, dropPoint, pickUpTime, dropTime, amount);
		Welcome.customerList.add(customer);

		TaxiAllocation.taxiallocation();
	} 
}
