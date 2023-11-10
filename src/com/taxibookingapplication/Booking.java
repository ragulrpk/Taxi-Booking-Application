package com.taxibookingapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Booking{
	
	 public static void TaxiBooking() throws IOException
	    {
		 //to get input from the customer
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Customer Id :"+(++DataStorage.count));
	        DataStorage.customerid.add(DataStorage.count);
	        System.out.print("Pick Point  :");
	        DataStorage.pickuppoint.add(br.readLine().charAt(0)); 
	        System.out.print("Drop Point  :");
	        DataStorage.droppoint.add(br.readLine().charAt(0));
	        System.out.print("Pickup Time :");
	        DataStorage.pickuptime.add(Integer.parseInt(br.readLine()));
	        TaxiAllocation.taxiallocation();
	    } 
}
