package ViewTables;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class ViewDefensivePlayers {
    // View Defensive Players Table
	public static void ViewDefensivePlayers(){
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
			String q = "SELECT * FROM Defensive_Player WHERE Season = " + Season + " ORDER  BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
			
			// defines the strings that will be used
			String Player_Name, Jersey_Number, Birthday, Team_Name, Position, SeasonName, Touchdowns, Sacks, Rushing_Yards, Interceptions, Tackles;

			// print results
			while(rs.next()) {
				Player_Name   = rs.getString("Player_Name");
				Jersey_Number = rs.getString("Jersey_Number");
				Birthday      = rs.getString("Birthday");
				Team_Name     = rs.getString("Team_Name");				
				Position      = rs.getString("Position");
				SeasonName    = rs.getString("Season");
                Touchdowns    = rs.getString("Touchdowns");
                Rushing_Yards = rs.getString("Rushing_Yards");
                Sacks         = rs.getString("Sacks");	
                Interceptions = rs.getString("Interceptions");			
				Tackles       = rs.getString("Tackles");
				Player_Name   = StringLength.stringLength(Player_Name, 25);
				Jersey_Number = StringLength.stringLength(Jersey_Number, 3);
				Birthday      = StringLength.stringLength(Birthday, 11);
				Team_Name     = StringLength.stringLength(Team_Name, 25);
                Position      = StringLength.stringLength(Position, 16);
                Rushing_Yards = StringLength.stringLength(Rushing_Yards, 13);
				Touchdowns    = StringLength.stringLength(Touchdowns, 13);
				Sacks         = StringLength.stringLength(Sacks, 13);
				Interceptions = StringLength.stringLength(Interceptions, 13);
				Tackles       = StringLength.stringLength(Tackles, 13);
				System.out.println(
				  "|||      Player_Name: "      + Player_Name 
				+ "  Jersey Number: "  + Jersey_Number 
				+ "  Birthday: "       + Birthday 
				+ "  Team Name: "      + Team_Name 
				+ "  Position: "       + Position 
				+ "  Season Name: "    + SeasonName 
				+ "  Touchdowns: "     + Touchdowns 
				+ "  Sacks: "          + Sacks 
                + "  Rushing Yards: "  + Rushing_Yards
                + "  Interceptions: "  + Interceptions
				+ "  Tackles: " + Tackles + "  |||");
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
