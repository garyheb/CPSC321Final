package AddRecords;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class AddToDefense {
    // Add to the Head_Coach table
	public static void AddToDefense(){
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
            
            int SeasonName       = getSeason.getSeason();
            String Team_Name     = getTeam.getTeam();
            System.out.print("Please enter player name: ");
            String playerName    = scanner.nextLine();
            String birthday = getBirthday.getBirthday();
            String jerseyNumber = getJerseyNumber.getJerseyNumber();
            String touchdowns   = getTouchdowns.Touchdowns();
            String rushingYards = getRushingYards.rushingYards();
            String sacks        = getSacks.sacks();
            String tackles      = getTackles.Tackles();
            String interceptions = getInterceptions.interceptions();
            String position     = "Linebacker";

			// create and execute query
            Statement stmt = con.createStatement();
            String q = "INSERT INTO Defensive_Player VALUES ('" + playerName + "', '" + birthday + "', " + jerseyNumber + ", " + touchdowns + "', " + rushingYards + "', " + sacks + "', " + tackles + "', " + interceptions + "', " + position + "', " + SeasonName + "', " + Team_Name + ");";
            stmt.executeUpdate(q);


            q = "SELECT * FROM Defensive_Player WHERE Season = " + SeasonName + " ORDER BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
            String Season, Superbowl = "";
			// print results
			while(rs.next()) {
				playerName     = rs.getString("Player_Name");
				Season         = rs.getString("Season");
                Team_Name      = rs.getString("Team_Name");
				playerName     = StringLength.stringLength(playerName, 25);
				Team_Name      = StringLength.stringLength(Team_Name,  25);
				System.out.println(
				  "|||      Player Name: "      + playerName 
				+ "  Season: "          + SeasonName
				+ "  Team Name : "      + Team_Name  + "  |||");
			}

			// release resources
			rs.close();
            
            //releases resources
			stmt.close();
            con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
