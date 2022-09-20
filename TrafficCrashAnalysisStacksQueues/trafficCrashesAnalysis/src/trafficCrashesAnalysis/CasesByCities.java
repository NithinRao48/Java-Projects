package trafficCrashesAnalysis;

import java.util.*;


/** 
 * CasesByCities.java - A custom class for storing accidents occurring in Cities
 * @author nsrao
 */

public class CasesByCities {
	
	String city;
	int count;
	ArrayList<String> rd_arr;
	
	
	/**
	 * Parameterized Constructor
	 * @param cit
	 * @param rdArr
	 * @param c
	 */
	
	CasesByCities(String cit,ArrayList<String> rdArr,int c){
		city = cit;
		rd_arr = rdArr;
		count =c;
	}

	/**
	 * Return the count of accidents 
	 * @return Integer Data Type
	 */
	
	public int getCount()
	{
		return count;
	}
	
	/**
	 * Return the city Name  
	 * @return String Data Type
	 */
	
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Prints the accident details 
	 */
	
	public void printinfo()
	{
		System.out.println("city:"+city+"\tcount:"+count);
		
	}

}
