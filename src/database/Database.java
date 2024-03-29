package database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import entities.Property;
import entities.RegisteredUser;

public class Database 
{
	public static Connection con;
	private final static String username = "root";
	private final static String password = "12345";
	
	public Boolean queryUser(RegisteredUser u)
	{
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  users");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
               String rUser= result.getString("user_name");
               String rPass = result.getString("password");
               if((rUser.equals(u.getName()) && (rPass.equals(u.getPassword())) ))
               {
            	   return true;
               }
            }

            	
            con.close();
            return false;
        }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return false;
	}
	
	// registered user = 0, landlord = 1, manager = 2
	public int verifyType(RegisteredUser u)	{
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  users");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
               String rUser= result.getString("user_name");
               String rPass = result.getString("password");
               if((rUser.equals(u.getName()) && (rPass.equals(u.getPassword())) ))
               {
            	   if(result.getString("user_type").equals("landlord")) {
            		   return 1;
            	   }
            	   if(result.getString("user_type").equals("manager")) {
            		   return 2;
            	   }
            	   else 
            		   return 0;
               }
            }

            	
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return -1;
	}
	
	public ArrayList<Property> fillManagerList()
	{
		ArrayList<Property> p = new ArrayList<Property> ();
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  properties");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
            	Property prop = new Property();
            	prop.setAddress(result.getString("property_address")); 
            	prop.setFurnished(result.getString("furnished"));
            	prop.setNumOfBaths(result.getInt("bath_num"));
            	prop.setNumOfRooms(result.getInt("bed_num"));
            	prop.setPropertyID(result.getInt("property_id"));
            	prop.setPropertyState(result.getInt("state"));
            	prop.setPropertyType(result.getString("type"));
            	prop.setQuadrant(result.getString("quadrant"));
            	prop.setIndexString();
            	p.add(prop);
            	
            }
        }
		
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return p;
	}
	public ArrayList<Property> fillList()
	{
		ArrayList<Property> p = new ArrayList<Property> ();
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  properties where state = '1' ");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
            	Property prop = new Property();
            	prop.setAddress(result.getString("property_address")); 
            	prop.setFurnished(result.getString("furnished"));
            	prop.setNumOfBaths(result.getInt("bath_num"));
            	prop.setNumOfRooms(result.getInt("bed_num"));
            	prop.setPropertyID(result.getInt("property_id"));
            	prop.setPropertyState(result.getInt("state"));
            	prop.setPropertyType(result.getString("type"));
            	prop.setQuadrant(result.getString("quadrant"));
            	prop.setIndexString();
            	p.add(prop);
            	
            }
        }
		
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return p;
	}
	
	public ArrayList<Property> fillReportList()
	{
		ArrayList<Property> p = new ArrayList<Property> ();
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  properties where state = '2' ");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
            	Property prop = new Property();
            	prop.setAddress(result.getString("property_address")); 
            	prop.setFurnished(result.getString("furnished"));
            	prop.setNumOfBaths(result.getInt("bath_num"));
            	prop.setNumOfRooms(result.getInt("bed_num"));
            	prop.setPropertyID(result.getInt("property_id"));
            	prop.setPropertyState(result.getInt("state"));
            	prop.setPropertyType(result.getString("type"));
            	prop.setQuadrant(result.getString("quadrant"));
            	prop.setIndexString();
            	p.add(prop);
            	
            }
        }
		
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return p;
	}
	
	
	public ArrayList<Property> getLandLordProps(String name)
	{
		ArrayList<Property> p = new ArrayList<Property> ();
		try
        {
            createConnection();
            PreparedStatement statement =  con.prepareStatement("SELECT * from  rentingdb.properties");/*write query inside of prepared statement*/
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
            	if(result.getString("user_owner").equals(name))
            	{
	            	Property prop = new Property();
	            	prop.setAddress(result.getString("property_address")); 
	            	prop.setFurnished(result.getString("furnished"));
	            	prop.setNumOfBaths(result.getInt("bath_num"));
	            	prop.setNumOfRooms(result.getInt("bed_num"));
	            	prop.setPropertyID(result.getInt("property_id"));
	            	prop.setPropertyState(result.getInt("state"));
	            	prop.setPropertyType(result.getString("type"));
	            	prop.setQuadrant(result.getString("quadrant"));
	            	prop.setIndexString();
	            	p.add(prop);
            	}
            	
            }
        }
		
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
		return p;
	}
	
	public static void main(String[] args) 
	{ 
		Database db = new Database();
		ArrayList<Property> p = db.fillList();
		for(int i =0; i<p.size();i++)
		{
			System.out.println(p.get(i).getIndexString());
		}
		
	}
	
	public void executeQuery(String theQuery) 
	{
		createConnection();
		try {
			PreparedStatement statement = con.prepareStatement(theQuery);
			statement.executeUpdate(theQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
		
	}
	
	 public static void createConnection()
	  {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentingdb",username,password);
	            System.out.println("Remote DB connection established");
	        }
	        catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote server could not be connected");
	        }
	        catch (NullPointerException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote server could not be connected");
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote db connection establishment error");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("False query");
	        }
	    }
	 
	 
	 
	 
		public void updateStateOfPropertiesIfOverduePayment()	{
			try
	        {
	            createConnection();
	            PreparedStatement statement =  con.prepareStatement("UPDATE rentingdb.properties, rentingdb.users SET state = 2 WHERE state = 1\r\n" + 
	            		"AND user_owner = users.user_name AND payment_due < NOW() and payment_paid is null;");
	            statement.executeUpdate();

	            con.close();
	        }
			catch(SQLException e)
			{
				e.printStackTrace();
				
				System.err.println("SQL ERROR");
			}
			return;

		}
		
		public void updateStateOfPropertiesIfPaid()	{
			try
	        {
	            createConnection();
	            PreparedStatement statement =  con.prepareStatement("UPDATE rentingdb.properties, rentingdb.users SET state = 1 WHERE state = 2\r\n" + 
	            		"AND user_owner = users.user_name AND payment_paid is not null;");
	            statement.executeUpdate();

	            con.close();
	        }
			catch(SQLException e)
			{
				e.printStackTrace();
				
				System.err.println("SQL ERROR");
			}
			return;

		}

		public boolean needtoPaid(RegisteredUser u) {
			try {
				if (queryUser(u)) {
					createConnection();
					PreparedStatement statement = con.prepareStatement("SELECT payment_paid from users where users.user_name = '" 
																		+ u.getName() + "';" );
					ResultSet result = statement.executeQuery();
					
					
					
					while (result.next()) {
						Timestamp toCompare = result.getTimestamp("payment_paid");
						System.out.println(toCompare);
						if (toCompare == null)
							return true;
						else
							return false;
					}
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				
				System.err.println("SQL ERROR");
			}
			return false;
		}
}