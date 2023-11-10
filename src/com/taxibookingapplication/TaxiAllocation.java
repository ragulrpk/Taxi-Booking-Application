package com.taxibookingapplication;

public class TaxiAllocation{

	static int droptime;
	static int fare;
	static int pickUpDropTimeflag = -1;
	public static void taxiallocation()
	{

		fairanddistancecalculation();

		// to compare and store the latest pick up and drop time in the arraylist for the particular taxi
		pickUpDropTimeflag = -1;
		int minGap = Integer.MAX_VALUE;
		
		

		
		for(int i=0 ; i<DataStorage.droptimetem.size(); i++) {		
			if(DataStorage.droptimetem.get(i) <= DataStorage.pickuptime.get(DataStorage.count-1)) {
				int differenceBtwnDropAndPickUp = Math.abs(DataStorage.droppoint.get(i) - DataStorage.pickuppoint.get(DataStorage.count-1));
				if(minGap > differenceBtwnDropAndPickUp) {
					minGap = differenceBtwnDropAndPickUp;
					pickUpDropTimeflag = i;
				}
			}
		}

		// if no drop time is less than or equal to pick up time, then assign new taxi
		if(pickUpDropTimeflag==-1) {
			pickUpDropTimeflag = DataStorage.droptimetem.size();
			DataStorage.pickuptimetem.add(DataStorage.pickuptime.get(DataStorage.count-1));
			DataStorage.droptimetem.add(droptime);
		}else {
			DataStorage.pickuptimetem.set(pickUpDropTimeflag,DataStorage.pickuptime.get(DataStorage.count-1));
			DataStorage.droptimetem.set(pickUpDropTimeflag, droptime);
		}

		savedata();

		System.out.println("-------------------------------------------");
		System.out.println("Congratulations. Taxi "+(pickUpDropTimeflag+1)+" has been successfully assigned. It will reach the desination at "+droptime+". The Fare will be Rs. "+fare);
		System.out.println("-------------------------------------------");

	}

	private static void savedata() {

		DataStorage.amount.add(fare);
		DataStorage.droptime.add(droptime);
		DataStorage.taxiAssigned.put((pickUpDropTimeflag+1), 1);
		DataStorage.taxi.add("Taxi_"+(pickUpDropTimeflag+1));
	}

	private static void fairanddistancecalculation() {

		droptime = DataStorage.pickuptime.get(DataStorage.count-1)+Math.abs(DataStorage.droppoint.get(DataStorage.count-1).compareTo(DataStorage.pickuppoint.get(DataStorage.count-1)));
		fare=100+(((Math.abs(DataStorage.droppoint.get(DataStorage.count-1).compareTo(DataStorage.pickuppoint.get(DataStorage.count-1)))*15)-5)*10);
	}  
}
