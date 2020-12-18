package ViewTables;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class Teams {
    // View Teams Table
	public static void ViewTeams(){
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
            
            // get user input here
			int Season = getSeason.getSeason();

			// create and execute query
			Statement stmt = con.createStatement();
			String q = "SELECT * FROM Team WHERE Season = " + Season;
			ResultSet rs = stmt.executeQuery(q);

			// print results
			while(rs.next()) {
				String Team_Name   = rs.getString("Team_Name");
				String SeasonName  = rs.getString("Season");
				String Wins        = rs.getString("Wins");
				String Losses      = rs.getString("Losses");
				String Draws       = rs.getString("Draws");
				String Superbowl   = rs.getString("Superbowl_Wins");
				Team_Name          = StringLength.stringLength(Team_Name, 25);
				Wins               = StringLength.stringLength(Wins, 3);
				Losses             = StringLength.stringLength(Losses, 3);
				Draws              = StringLength.stringLength(Draws, 3);
				Superbowl          = StringLength.stringLength(Superbowl, 3);
				System.out.println("Team Name: " + Team_Name + " Season: " + SeasonName + "  Wins: " + Wins + "  Losses: " + Losses + "  Superbowl Wins: " + Superbowl);
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
