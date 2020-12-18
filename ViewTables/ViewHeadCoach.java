package ViewTables;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class ViewHeadCoach {
    // View Head_Coach Table
	public static void ViewHeadCoach(){
		try {
			//  create  connection
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream("config.properties");
			prop.load(in);
			in.close();
			
			// connect to datbase
			String hst = prop.getProperty("host");
			String usr = prop.getProperty("user");
			String pwd = prop.getProperty("password");
			String dab = "gheberling_DB";
			String url = "jdbc:mysql://" + hst + "/" + dab;
			Connection con = DriverManager.getConnection(url, usr, pwd);
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Please enter Season you wish to view:");
			String Input  = scanner.nextLine();
			int Season = Integer.parseInt(Input);

			// create and execute query
			Statement stmt = con.createStatement();
			String q = "SELECT * FROM Head_Coach WHERE Season = " + Season + " ORDER BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
			
			// defines the strings that will be used
			String Coach_Name, Superbowl_Wins, SeasonName, Team_Name;

			// print results
			while(rs.next()) {
				Coach_Name     = rs.getString("Coach_Name");
				Superbowl_Wins = rs.getString("Superbowl_Wins");
				SeasonName     = rs.getString("Season");
                Team_Name      = rs.getString("Team_Name");
				Coach_Name   = StringLength.stringLength(Coach_Name, 25);
				Superbowl_Wins = StringLength.stringLength(Superbowl_Wins, 3);
				Team_Name     = StringLength.stringLength(Team_Name, 25);
				System.out.println(
				  "|||      Coach Name: "      + Coach_Name 
				+ "  Superbowl Wins: "  + Superbowl_Wins 
				+ "  Season: "          + SeasonName
				+ "  Team Name : "      + Team_Name  + "  |||");
			}

			// release resources
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

