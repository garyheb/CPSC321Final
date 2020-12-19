package AddRecords;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class AddToTeam {
    // Add to the Head_Coach table
	public static void AddTeam(){
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
            System.out.println("Please enter the team name you would like to add:");
            String Team_Name     = scanner.nextLine();
            System.out.println("Please enter the number of wins");
            int wins = getInt.getInt();
            if(wins > 16){
                System.out.println("wins cannot exceed than 16");
                wins = getInt.getInt();
            }
            System.out.println("Please enter the number of losses");
            int losses = getInt.getInt();
            while(losses + wins > 16){
                System.out.println("The team has to play 16 games a season");
                losses = getInt.getInt();
            }
            
            int draws = 0;
            if((losses + wins) < 16){
                draws = (16 - (wins + losses));
            } 

            System.out.print("Please enter superbowl wins: ");
            int Superbowl_Wins   = getInt.getInt();
			// create and execute query
            Statement stmt = con.createStatement();
            String q = "INSERT INTO Team VALUES ( \"" + Team_Name + "\", " + wins + ", " + losses  + ", " + draws + ", " +  Superbowl_Wins + ", " + SeasonName + ");";
            stmt.executeUpdate(q);


            q = "SELECT * FROM Team WHERE Season = " + SeasonName + " ORDER BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
            String Season, Superbowl = "";
			// print results
			while(rs.next()) {
				Team_Name     = rs.getString("Team_Name");
				Superbowl      = rs.getString("Superbowl_Wins");
				Season         = rs.getString("Season");
                Team_Name      = rs.getString("Team_Name");
				Team_Name     = StringLength.stringLength(Team_Name, 25);
				Superbowl      = StringLength.stringLength(Superbowl,   3);
				Team_Name      = StringLength.stringLength(Team_Name,  25);
				System.out.println(
				  "|||      Team Name: " + Team_Name 
				+ "  Superbowl Wins: "   + Superbowl_Wins 
				+ "  Season: "           + SeasonName
				+ "  Team Name : "       + Team_Name  + "  |||");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}