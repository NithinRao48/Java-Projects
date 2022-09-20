package TrafficCrashAnalysisChicago;

/**
 * TrafficAccident.java - a custom object which stores the traffic accident record 
 * @author nsrao
 */
public class TrafficAccident {

	private String person_ID;
	private String person_Type;
	private String rd_NO;
	private String vehicle_ID;
	private String crash_Date;
	private String gender;
	private String age;
	private String city;
	private String zipcode;
	
	/**
	 * Default Constructor
	 */
	
	public TrafficAccident ()
	{
		this.person_ID="";
		this.person_Type="";
		this.rd_NO = "";
		this.vehicle_ID="";
		this.crash_Date="";
		this.gender="";
		this.age="";
		this.city="";
		this.zipcode="";
		
	}
	
	/**
	 * Parameterized Constructor
	 */
	public TrafficAccident (String person_ID,String person_Type,String rd_NO,String vehicle_ID,String crash_Date,String gender,String age,String city,String zipcode)
	{
		this.person_ID=person_ID;
		this.person_Type=person_Type;
		this.rd_NO = rd_NO;
		this.vehicle_ID=vehicle_ID;
		this.crash_Date=crash_Date;
		this.gender=gender;
		this.age=age;
		this.city=city;
		this.zipcode=zipcode;
		
	}
	
	/**
	 * Display the traffic accident record details
	 */
	
	public void printInfo ()
	{
		System.out.println(person_ID+"\t"+person_Type+"\t"+rd_NO+"\t"+vehicle_ID+"\t"+crash_Date+"\t"+gender+"\t"+age+"\t"+city+"\t"+zipcode+"\n");
	}
	
	/**
	 * Get person ID
	 * @return person ID
	 */
	public String getPersonID()
	{
		return this.person_ID;
	}
	
	/**
	 * Get person type
	 * @return person type
	 */
	
	
	public String getPersonType()
	{
		return this.person_Type;
	}
	
	/**
	 * Get RD Number associated with each case
	 * @return rd No
	 */
	
	public String getRD_NO()
	{
		return this.rd_NO;
	}
	
	/**
	 * Get gender information
	 * @return gender
	 */
	
	public String getGender()
	{
		return this.gender;
	}
	
	/**
	 * Get age information
	 * @return age 
	 */
	
	public String getAge()
	{
		return this.age;
	}
	
	/**
	 * Get city information
	 * @return city name
	 */
	
	public String getCity()
	{
		return this.city;
	}
	
	/**
	 * Get Zipcode information
	 * @return zipcode
	 */
	
	
	public String getZipCode()
	{
		return this.zipcode;
	}
	
	/**
	 * Get Vehicle ID
	 * @return vehicle ID
	 */
	
	public String getVehicleId()
	{
		return this.vehicle_ID;
	}
	
	/**
	 * Get Crash date
	 * @return crash date
	 */
	
	public String getCrashDate()
	{
		return this.crash_Date;
	}
	

}
