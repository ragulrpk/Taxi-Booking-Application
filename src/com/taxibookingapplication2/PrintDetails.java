package com.taxibookingapplication2;

import java.util.*;

public class PrintDetails {
	
	private static PrintDetails instance;

    private PrintDetails() {
    	
    }

    public static PrintDetails getInstance() {
        if (instance == null) {
            instance = new PrintDetails();
        }
        return instance;
    }
	
	public void TaxiDetails() {
		System.out.println("------------------------------------------------------------------------------------------");
		if(Welcome.total_customer==0) {
			System.out.println("All taxi's are available. Trip is yet to start.");
			return;
		}
		
		Set<String> totalTaxi = Welcome.taxiDetails.keySet();
		
		for(String taxi : totalTaxi) {
			System.out.println(taxi+"---------------------------------------------------------Total Earnings : "+Welcome.taxiTotalEarnings.get(taxi));
			System.out.println("S.N0 | Customer id | PickUp Point | Drop Point | Pickup Time | Drop Time | Amount |");
			System.out.println("-----------------------------------------------------------------------------------");
			ArrayList<Customer> customer = Welcome.taxiDetails.get(taxi);
			int sno = 1;
			for(int i=0; i<customer.size() ; i++) {
				Customer cus = customer.get(i);
				System.out.println(sno+"    |      "+cus.getCustomerID()+"      |      "+cus.getPickUpPoint()+"       |     "+cus.getDropPoint()+"      |      "+cus.getPickUpTime()+"      |     "+cus.getDropTime()+"    |  "+cus.getAmount()+"   |");
				sno++;
			}
			System.out.println("-----------------------------------------------------------------------------------");
		}
	}
	
	public void CustomerDetails() {
		
		System.out.println("------------------------------------------------------------------------------------------");
		if(Welcome.total_customer==0) {
			System.out.println("No Customers Detail is available.");
			return;
		}
		
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("S.N0 | Customer id | PickUp Point | Drop Point | Pickup Time | Drop Time | Amount |   Taxi   |");
		System.out.println("---------------------------------------------------------------------------------------------");
		int sno = 1;
		for(int i=0; i<Welcome.customerList.size() ; i++) {
			Customer cus = Welcome.customerList.get(i);
			System.out.println(sno+"    |      "+cus.getCustomerID()+"      |      "+cus.getPickUpPoint()+"       |     "+cus.getDropPoint()+"      |      "+cus.getPickUpTime()+"      |     "+cus.getDropTime()+"    |  "+cus.getAmount()+"   |   "+cus.getTaxiNo()+"   |");
			sno++;
		}
	}
	
	public void FreeTaxi() {
		System.out.println("------------------------------------------------------------------------------------------");
		if(Welcome.total_customer==0) {
			System.out.println("All taxi's are available");
			return;
		}
		
		System.out.println("|------------------------------------------ Taxi -----------------------------------------|");
		int pickUpTime = Welcome.customerList.get(Welcome.total_customer-1).getPickUpTime();
		for(int i=0 ; i<Welcome.droptimetem.size(); i++) {
			if(pickUpTime < Welcome.droptimetem.get(i)) {
				System.out.println("Taxi_"+(i+1));
			}
		}
	}
}
