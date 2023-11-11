package com.taxibookingapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewDetails{

	public  static void View() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintDetails printDetails = PrintDetails.getInstance();
		while(true) {
			System.out.println("Enter 1 to view the Taxi Details");
			System.out.println("Enter 2 to view the Customer Details");
			System.out.println("Enter 3 to view the Taxi Currently in Use");
			System.out.println("Enter 4 to Welcome Page");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("Enter Your Choice : ");
			int userchoice = Integer.parseInt(br.readLine().trim());
			switch(userchoice) {
			case 1:
				printDetails.TaxiDetails();
				System.out.println("------------------------------------------------------------------------------------------");
				break;
			case 2:
				printDetails.CustomerDetails();
				System.out.println("------------------------------------------------------------------------------------------");
				break;
			case 3:
				printDetails.FreeTaxi();
				System.out.println("------------------------------------------------------------------------------------------");
				break;
			case 4:
				System.out.println("Going Back to the Welcome Page");
				return;
			}
		}
	}
}
