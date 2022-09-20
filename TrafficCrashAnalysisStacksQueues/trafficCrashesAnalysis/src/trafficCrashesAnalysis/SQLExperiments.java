package trafficCrashesAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


/**
 * SQLExperiments.java - Query Driven method for all the underlying experiments
 * @author nsrao
 */
public class SQLExperiments {
	
	/**
	 * Search the Traffic Accident record using Vehicle ID
	 * @param connection
	 * @param str
	 * @return ResultSet
	 */
	public static ResultSet searchAccidentHistoryVehicleIdSQL(Connection connection,String str)
	{
		
		try {
			String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	        PreparedStatement statement;
	        statement = connection.prepareStatement(sql);
	        ResultSet rs = null;
	        rs = statement.executeQuery("select * from traffic_crashes_people where vehicle_id = '"+str+"';");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	        return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Search the Traffic Accident record using Person ID
	 * @param connection
	 * @param str
	 * @return
	 */
	
	public static ResultSet searchByPersonIdSQL(Connection connection,String str)
	{
		
		try {
			String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	        PreparedStatement statement;
	        statement = connection.prepareStatement(sql);
	        ResultSet rs = null;
	        rs = statement.executeQuery("select * from traffic_crashes_people where person_id = '"+str+"';");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	        return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Search the Traffic Accident record using RD Number
	 * @param connection
	 * @param str
	 * @return
	 */
	public static ResultSet SearchVictimsByRdNoSQL(Connection connection,String str)
	{      
		
		try {
			String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	        PreparedStatement statement;
	        statement = connection.prepareStatement(sql);
	        ResultSet rs = null;
	        rs = statement.executeQuery("select * from traffic_crashes_people where rd_no = '"+str+"';");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	        return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Search count of Accident Cases occurred on a particular Date
	 * @param connection
	 * @param str
	 * @return
	 */
	
	public static ResultSet SearchCountofCasesByDateSQL(Connection connection,String str)
	{
		
	try {
			
			String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	        PreparedStatement statement;
	        ResultSet rs = null;
	        statement = connection.prepareStatement(sql);
	        rs = statement.executeQuery("select COUNT(DISTINCT(rd_no)) from traffic_crashes_people where crash_date= '"+str+"' group by crash_date;"); // where vehicle_id = '645598'
	        ResultSetMetaData rsmd = rs.getMetaData();
	        //rs = statement.getResultSet();
	        int columnsNumber = rsmd.getColumnCount();
	        return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	/**
	 * Search Top N Cities sorted by count of Accidents occurring
	 * @param connection
	 * @param str
	 * @return
	 */
	public static ResultSet TopNCitiesWithAccidentsSQL(Connection connection,String str)
	{
		
	try {
			String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	        PreparedStatement statement;
	        statement = connection.prepareStatement(sql);
	        ResultSet rs = null;
	        rs = statement.executeQuery("select city, COUNT(DISTINCT(rd_no)) as cases from traffic_crashes_people group by city order by cases desc limit "+Integer.parseInt(str)+";"); // where vehicle_id = '645598'
	        ResultSetMetaData rsmd = rs.getMetaData();
	        //rs = statement.getResultSet();
	        int columnsNumber = rsmd.getColumnCount();
	        return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	return null;
	}
	
	/**
	 * Insert a single Traffic accident record to Database entered by User from UI.
	 * @param ta
	 */
	public static void InsertOneIntoDB(TrafficAccident ta) {
		String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
        String username = "root";
        String password = "chicharito10";
        String csvFilePath = "C:/Users/nsrao/TrafficCrashesChicagoData.csv"; 
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            

            statement.setString(1, ta.getPersonID());
            statement.setString(2, ta.getPersonType());
            statement.setString(3, ta.getRD_NO());
            statement.setString(4, ta.getVehicleId());
            statement.setString(5, ta.getCrashDate());
            statement.setString(6, ta.getGender());
            statement.setString(7, ta.getAge());
            statement.setString(8, ta.getCity());
            statement.setString(9, ta.getZipCode());

            statement.executeUpdate();
            //statement.executeBatch();            
            System.out.println("Done successfully.");
            connection.commit();
            //connection.close();
 
        } catch (Exception ex) {
            //do nothing
            try {
                connection.rollback();
            } catch (SQLException e) {
                // do nothing
            }
        }
        
	}
	
	/**
	 * Insert the data into DB from Excel Recorsd
	 */

	public static void InsertIntoDB() {
		String jdbcURL = "jdbc:mysql://localhost:3306/trafficAccident";
        String username = "root";
        String password = "chicharito10";
        String csvFilePath = "src/TrafficCrashesChicagoData.csv"; 
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO traffic_crashes_people (person_id, person_type, rd_no,vehicle_id, crash_date,sex,age,city,zip_code) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null; 
            lineReader.readLine(); // skip header line
           

            while ((lineText = lineReader.readLine()) != null) {
            	String[] data = lineText.split(",");
            	String person_id = data[0];
	            String person_type = data[1];
	            String rd_no = data[2];
	            String vehicle_id = data[3];
	            String crash_date = data[4];
	            String sex=data[5];
	            String age=data[6];
	            String city=data[7];
	            String zipcode = data[8];
	            
	            
	            statement.setString(1, person_id);
                statement.setString(2, person_type);
                statement.setString(3, rd_no);
                statement.setString(4, vehicle_id);
                statement.setString(5, crash_date);
                statement.setString(6, sex);
                statement.setString(7, age);
                statement.setString(8, city);
                statement.setString(9, zipcode);

                statement.addBatch();
                
                
            }
            lineReader.close();
            statement.executeBatch();            
            System.out.println("Done successfully.");
            connection.commit();
            //connection.close();
 
        } catch (IOException ex) {
            // do nothing
        } catch (Exception ex) {
            //do nothing
            try {
                connection.rollback();
            } catch (SQLException e) {
                // do nothing
            }
        }
	}
}
