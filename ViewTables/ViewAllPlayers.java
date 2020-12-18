package ViewTables;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class ViewAllPlayers {
    // View All Players Table for a particular team/season
	public static void ViewAllPlayers(){
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
            int Season  = getSeason.getSeason();

			// create and execute query
            Statement stmt = con.createStatement();

            String Team_Name = getTeam.getTeam();
            
            String q =  "SELECT Player_Name, Jersey_Number, Birthday, Team_Name, Position, Season FROM Quarterback WHERE Season = "      + Season + " AND Team_Name = " + Team_Name +
                 " UNION SELECT Player_Name, Jersey_Number, Birthday, Team_Name, Position, Season FROM Offensive_Player WHERE Season = " + Season + " AND Team_Name = " + Team_Name + 
                 " UNION SELECT Player_Name, Jersey_Number, Birthday, Team_Name, Position, Season FROM Defensive_Player WHERE Season = " + Season + " AND Team_Name = " + Team_Name;
            System.out.println(q);
            ResultSet rs = stmt.executeQuery(q);           
			
			// defines the strings that will be used
			String Player_Name, Jersey_Number, Birthday, Position, SeasonName;

			// print results
			while(rs.next()) {
				Player_Name   = rs.getString("Player_Name");
				Jersey_Number = rs.getString("Jersey_Number");
				Birthday      = rs.getString("Birthday");
				Team_Name     = rs.getString("Team_Name");				
				Position      = rs.getString("Position");
				SeasonName    = rs.getString("Season");
				Player_Name   = StringLength.stringLength(Player_Name, 25);
				Jersey_Number = StringLength.stringLength(Jersey_Number, 3);
				Birthday      = StringLength.stringLength(Birthday, 11);
				Team_Name     = StringLength.stringLength(Team_Name, 25);
                Position      = StringLength.stringLength(Position, 16);
				System.out.println(
				  "|||      Player_Name: "      + Player_Name 
				+ "  Jersey Number: "  + Jersey_Number 
				+ "  Birthday: "       + Birthday 
				+ "  Team Name: "      + Team_Name 
				+ "  Position: "       + Position 
				+ "  Season Name: "    + SeasonName + "  |||");
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
