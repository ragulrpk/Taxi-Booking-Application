package com.taxibookingapplication2;

import java.util.ArrayList;

public class TaxiAllocation{

	public static void taxiallocation()
	{

		// to compare and store the latest pick up and drop time in the arraylist for the particular taxi
		int taxiNo = -1;
		int minGap = Integer.MAX_VALUE;
		Customer customer = Welcome.customerList.get(Welcome.total_customer-1);

		for(int i=0 ; i<Welcome.droptimetem.size(); i++) {
			if(Welcome.droptimetem.get(i) <= customer.getPickUpTime()) {
				int differenceBtwnDropAndPickUp = Math.abs(customer.getDropPoint()-customer.getPickUpPoint());
				if(minGap > differenceBtwnDropAndPickUp) {
					minGap = differenceBtwnDropAndPickUp;
					taxiNo = i;
				}else if(minGap == differenceBtwnDropAndPickUp) {
					minGap = differenceBtwnDropAndPickUp;
					long firstTaxi = Welcome.taxiTotalEarnings.get("Taxi_"+(taxiNo+1));
					long secondTaxi = Welcome.taxiTotalEarnings.get("Taxi_"+(i+1));
					taxiNo = firstTaxi<=secondTaxi?taxiNo:i;
				}
			}
		}

		if(customer.getPickUpPoint()=='a' ||  customer.getPickUpPoint()=='A' && minGap>0) {
			taxiNo = -1;
		}
		// if no drop time is less than or equal to pick up time, then assign new taxi
		if(taxiNo==-1) {
			taxiNo = Welcome.droptimetem.size();
			Welcome.pickuptimetem.add(customer.getPickUpTime());
			Welcome.droptimetem.add(customer.getDropTime());
		}else {
			Welcome.pickuptimetem.set(taxiNo,customer.getPickUpTime());
			Welcome.droptimetem.set(taxiNo, customer.getDropTime());
		}

		customer.setTaxiNo("Taxi_"+(taxiNo+1));


		if(Welcome.taxiDetails.containsKey(customer.getTaxiNo())) {
			ArrayList<Customer> customerDetails = Welcome.taxiDetails.get(customer.getTaxiNo());
			customerDetails.add(customer);
			long totalEarning = Welcome.taxiTotalEarnings.get(customer.getTaxiNo());
			totalEarning += customer.getAmount();
			Welcome.taxiDetails.put(customer.getTaxiNo(), customerDetails);
			Welcome.taxiTotalEarnings.put(customer.getTaxiNo(), totalEarning );
		}else {
			ArrayList<Customer> customerDetails = new ArrayList<>();
			customerDetails.add(customer);
			long totalEarning = customer.getAmount();
			Welcome.taxiDetails.put(customer.getTaxiNo(), customerDetails);
			Welcome.taxiTotalEarnings.put(customer.getTaxiNo(), totalEarning);
		}

		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Congratulations. "+customer.getTaxiNo()+" has been successfully assigned. It will reach the desination at "+customer.getDropTime()+". The Fare will be Rs. "+customer.getAmount());

	}

}
