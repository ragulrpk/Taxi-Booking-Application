package com.taxibookingapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class DataStorage {

	public static int count=0;
	static ArrayList<Integer> customerid = new ArrayList<>();
	static ArrayList<Character> pickuppoint = new ArrayList<>();
	static ArrayList<Character> droppoint   = new ArrayList<>();
	static ArrayList<Integer> pickuptime  = new ArrayList<>();
	static ArrayList<Integer> droptime  = new ArrayList<>();
	static ArrayList<String> taxi  = new ArrayList<>();
	static ArrayList<Integer> amount= new ArrayList<>();
	static HashMap<Integer,Integer> taxiAssigned = new HashMap<>();
	static ArrayList<Integer> pickuptimetem  = new ArrayList<>();
	static ArrayList<Integer> droptimetem  = new ArrayList<>();
	
}
