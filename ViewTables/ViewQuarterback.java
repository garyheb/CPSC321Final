package ViewTables;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class ViewQuarterback {
    // View Quarterback Table
	public static void ViewQuarterback(){
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
			
			int Season = getSeason.getSeason();

			// create and execute query
			Statement stmt = con.createStatement();
			String q = "SELECT * FROM Quarterback WHERE Season = " + Season + " ORDER  BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
			
			// defines the strings that will be used
			String Player_Name, Jersey_Number, Birthday, Team_Name, Passes_Attempted, Passes_Completed, Completion_Perc, Position, Times_Sacked, Fumbles, SeasonName, Passing_TD , Rushing_TD, Passing_Yards, Rushing_Yards, Interceptions;

			// print results
			while(rs.next()) {
				Player_Name       = rs.getString("Player_Name");
				Jersey_Number     = rs.getString("Jersey_Number");
				Birthday          = rs.getString("Birthday");
				Team_Name         = rs.getString("Team_Name");				
				Position          = rs.getString("Position");
				SeasonName        = rs.getString("Season");
				Passing_TD        = rs.getString("Passing_TD");
                Passing_Yards     = rs.getString("Passing_Yards");
                Rushing_TD        = rs.getString("Rushing_TD");
				Rushing_Yards     = rs.getString("Rushing_Yards");
                Interceptions     = rs.getString("Interceptions");
                Times_Sacked      = rs.getString("Times_Sacked");
                Fumbles           = rs.getString("Fumbles");
                Completion_Perc   = rs.getString("Completion_Perc");
                Passes_Attempted  = rs.getString("Passes_Attempted");
                Passes_Completed  = rs.getString("Passes_Completed");
				Player_Name       = StringLength.stringLength(Player_Name,      25);
				Jersey_Number     = StringLength.stringLength(Jersey_Number,     3);
				Birthday          = StringLength.stringLength(Birthday,         11);
				Team_Name         = StringLength.stringLength(Team_Name,        25);
				Position          = StringLength.stringLength(Position,         16);
                Passing_TD        = StringLength.stringLength(Passing_TD,       13);
                Rushing_TD        = StringLength.stringLength(Rushing_TD,       13);
				Passing_Yards     = StringLength.stringLength(Passing_Yards,    13);
				Rushing_Yards     = StringLength.stringLength(Rushing_Yards,    13);
                Interceptions     = StringLength.stringLength(Interceptions,    13);
                Times_Sacked      = StringLength.stringLength(Times_Sacked,     13);
                Fumbles           = StringLength.stringLength(Fumbles,          13);
                Completion_Perc   = StringLength.stringLength(Completion_Perc,  13);
                Passes_Attempted  = StringLength.stringLength(Passes_Attempted, 13);
                Passes_Completed  = StringLength.stringLength(Passes_Completed, 13);
				System.out.println(
				  "|||      Player_Name: "  + Player_Name 
				+ "  Jersey Number: "       + Jersey_Number 
				+ "  Birthday: "            + Birthday 
				+ "  Team Name: "           + Team_Name 
				+ "  Position: "            + Position 
				+ "  Season Name: "         + SeasonName                
                + "  Rushing Yards : "      + Rushing_Yards
                + "  Rushing Touchdowns : " + Rushing_TD
                + "  Passing Yards: "       + Passing_Yards 
                + "  Passing Touchdowns : " + Passing_TD
                + "  Passes_Attempted: "    + Passes_Attempted
                + "  Passes_Completed: "    + Passes_Completed
                + "  Completion_Perc: "     + Completion_Perc    
                + "  Times Sacked: "        + Times_Sacked
                + "  Fumbles: "             + Fumbles               
				+ "  Interceptions: "       + Interceptions + "  |||\n");
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
