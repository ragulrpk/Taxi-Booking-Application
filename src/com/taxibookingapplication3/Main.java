package com.taxibookingapplication3;

import java.io.*;
import java.util.*;

class Input{
	Input(){ }
	public static int count=0;

	ArrayList<String> customerid = new ArrayList<>();
	ArrayList<String> start = new ArrayList<>();
	ArrayList<String> end   = new ArrayList<>();
	ArrayList<String> time  = new ArrayList<>();
	ArrayList<String> taxi  = new ArrayList<>();
	ArrayList<Integer> amount= new ArrayList<>();

	public int Taxi_1=0,Taxi_2=0,Taxi_3=0,Taxi_4=0;
	public String[] Taxi=new String[]{"Taxi_1","Taxi_2","Taxi_3","Taxi_4"};

	public  void Booking() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input       :"+(++count));
		System.out.print("Customer Id :");
		customerid.add(br.readLine());
		System.out.print("Pick Point  :");
		start.add(br.readLine()); 
		System.out.print("Drop Point  :");
		end.add(br.readLine());
		System.out.print("Pickup Time :");
		time.add(br.readLine());
		taxiallocation();
	} 
	////////////////////////////////////////////////////////////////////////////
	public void taxiallocation()
	{
		int flag=1;
		for(int i=0;i<count-1;i++)
		{
			if(Integer.parseInt(time.get(i))+(end.get(i).compareTo(start.get(i)))<=Integer.parseInt(time.get(count-1)))
			{ 
				String str=taxi.get(i);
				int num=Integer.parseInt(String.valueOf(str.charAt(5)));
				if(num==1)
				{
					Taxi_1=0;
				}
				else if(num==2)
				{
					Taxi_2=0;
				}
				else if(num==3)
				{
					Taxi_3=0;
				}
				else if(num==4)
				{
					Taxi_4=0;
				}
			}
		}
		if(Taxi_1==0)
		{
			flag=0;
			Taxi_1=1;
			taxi.add(Taxi[0]);
		}
		else if(Taxi_2==0)
		{
			flag=0;
			Taxi_2=1;
			taxi.add(Taxi[1]);
		}
		else if(Taxi_3==0)
		{
			flag=0;
			Taxi_3=1;
			taxi.add(Taxi[2]);
		}
		else if(Taxi_4==0)
		{
			flag=0;
			Taxi_4=1;
			taxi.add(Taxi[3]);
		}

		int amo=100+(((end.get(count-1).compareTo(start.get(count-1))*15)-5)*10);
		amount.add(amo);

		System.out.println();
		if(flag==0)
		{
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("TAXI CAN BE ALLOCATED");
			System.out.println(taxi.get(count-1)+" IS ALLOCATED");
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		}
		else
		{
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("ALL TAXI'S ARE BUSY");
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		}
		System.out.println();
	}
	public  void View()
	{
		System.out.println();
		int Earnings[]=new int[4];
		for(int i=0;i<4;i++)
		{
			int res=0;
			for(int j=0;j<count;j++)
			{
				if(Taxi[i].compareTo(taxi.get(j))==0)
				{
					res+=amount.get(j);
				}
			}
			Earnings[i]=res;
		}
		for(int j=0;j<4;j++)
		{   
			System.out.println(Taxi[j]+"      Total Earnings:"+Earnings[j]);
			System.out.println("-----------------------------------------------------------------");
			System.out.println("CustomerID  PickPoint  DropPoint  PickUpTime  DropTime  Amount");
			System.out.println("-----------------------------------------------------------------");
			for(int i=0;i<count;i++)
			{
				if(Taxi[j].compareTo(taxi.get(i))==0)
				{
					int dp=Integer.parseInt(time.get(i))+end.get(i).compareTo(start.get(i));
					System.out.println(customerid.get(i)+"            "+start.get(i)+"          "+end.get(i)+"          "+time.get(i)+"           "+dp+"          "+amount.get(i) );
				}
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
		}
	}

}
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Input input=new Input();
		while(true)
		{
			System.out.println("******************************************");
			System.out.println("WELCOME TO CALL TAXI SERVICES");
			System.out.println("******************************************");
			System.out.println("1.BOOKING  2.VIEW DETAILS 3.CANCEL");
			int choice=Integer.parseInt(br.readLine().trim());
			int flag=0;
			switch(choice)
			{
			case 1:
				flag=1;
				input.Booking();
				break;
			case 2:
				flag=1;
				input.View();
				break;
			case 3:
				flag=0;
				System.out.println("Booking has been cancelled");
				break;
			}
			if(flag==0)
			{
				break;
			}
		}
	}
}
