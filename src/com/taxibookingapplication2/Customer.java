package com.taxibookingapplication2;

public class Customer {

	private long customerID;
	private String customerName;
	private char pickUpPoint;
	private char dropPoint;
	private int pickUpTime;
	private int dropTime;
	private long amount;
	private String taxiNo;
	
	
	
	public Customer(long customerID, String customerName, char pickUpPoint, char dropPoint, int pickUpTime, int dropTime, long amount) {

		this.customerID = customerID;
		this.customerName = customerName;
		this.pickUpPoint = pickUpPoint;
		this.dropPoint = dropPoint;
		this.pickUpTime = pickUpTime;
		this.dropTime = dropTime;
		this.amount = amount;
	}

	
	public long getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public char getPickUpPoint() {
		return pickUpPoint;
	}


	public char getDropPoint() {
		return dropPoint;
	}

	public int getPickUpTime() {
		return pickUpTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public long getAmount() {
		return amount;
	}

	public String getTaxiNo() {
		return taxiNo;
	}

	public void setTaxiNo(String taxiNo) {
		this.taxiNo = taxiNo;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", pickUpPoint=" + pickUpPoint
				+ ", dropPoint=" + dropPoint + ", pickUpTime=" + pickUpTime + ", dropTime=" + dropTime + ", amount="
				+ amount + ", taxiNo=" + taxiNo + "]";
	}
	
	
	
}
