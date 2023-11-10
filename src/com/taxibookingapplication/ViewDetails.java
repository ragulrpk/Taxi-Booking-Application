package com.taxibookingapplication;

import java.util.HashMap;

public class ViewDetails{

	public  static void View()
	{
		HashMap<String,Integer> totalEarnings = new HashMap<>();
		int noOfTaxi = DataStorage.droptimetem.size();

		// to find the total Earning of Each taxi
		for(int i=0 ; i<DataStorage.taxi.size(); i++) {
			if(totalEarnings.containsKey(DataStorage.taxi.get(i))) {
				totalEarnings.put(DataStorage.taxi.get(i), totalEarnings.get(DataStorage.taxi.get(i))+DataStorage.amount.get(i));
			}else {
				totalEarnings.put(DataStorage.taxi.get(i), DataStorage.amount.get(i));
			}
		}

		for(int i=0 ; i<noOfTaxi ; i++) {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Taxi_"+(i+1)+"                                                        Total Earnings : "+totalEarnings.get("Taxi_"+(i+1)));
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("S.N0 | Customer id | PickUp Point | Drop Point | Pickup Time | Drop Time | Amount |");
			System.out.println("-----------------------------------------------------------------------------------");
			int sno = 1;
			for(int j=0; j<DataStorage.taxi.size() ; j++) {
				if(("Taxi_"+(i+1)).equals(DataStorage.taxi.get(j))){
					System.out.println(sno+"    |      "+DataStorage.customerid.get(j)+"      |      "+DataStorage.pickuppoint.get(j)+"       |     "+DataStorage.droppoint.get(j)+"      |      "+DataStorage.pickuptime.get(j)+"      |     "+DataStorage.droptime.get(j)+"    |  "+DataStorage.amount.get(j)+"   |");
					sno++;
				}
			}
			System.out.println("-----------------------------------------------------------------------------------");
		}
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Customer id   : "+DataStorage.customerid);
		System.out.println("Pick up Point : "+DataStorage.pickuppoint);
		System.out.println("Drop Point    : "+DataStorage.droppoint);
		System.out.println("Pick up Time  : "+DataStorage.pickuptime);
		System.out.println("Drop Time     : "+DataStorage.droptime);
		System.out.println("Amount        : "+DataStorage.amount);
		System.out.println("Taxi          : "+DataStorage.taxi);
		System.out.println("Taxi Assigned : "+DataStorage.taxiAssigned);
		System.out.println("Pick Up Time  : "+DataStorage.pickuptimetem);
		System.out.println("Drop Time     : "+DataStorage.droptimetem);
		System.out.println("-----------------------------------------------------------------------------------");
	}
}
