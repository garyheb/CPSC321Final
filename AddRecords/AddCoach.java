package AddRecords;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class AddCoach {
    // Add to the Head_Coach table
	public static void AddCoach(){
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
            System.out.print("Please enter coach name: ");
            String Coach_Name    = scanner.nextLine();
            System.out.print("Please enter superbowl wins: ");
            String Superbowl     = scanner.nextLine();
            int Superbowl_Wins   = Integer.parseInt(Superbowl);
			// create and execute query
            Statement stmt = con.createStatement();
            String q = "INSERT INTO Head_Coach VALUES ('" + Coach_Name + "', '" + Superbowl_Wins + "', " + SeasonName + ", " + Team_Name + ");";
            stmt.executeUpdate(q);


            q = "SELECT * FROM Head_Coach WHERE Season = " + SeasonName + " ORDER BY Team_Name";
			ResultSet rs = stmt.executeQuery(q);
            String Season = "";
			// print results
			while(rs.next()) {
				Coach_Name     = rs.getString("Coach_Name");
				Superbowl      = rs.getString("Superbowl_Wins");
				Season         = rs.getString("Season");
                Team_Name      = rs.getString("Team_Name");
				Coach_Name     = StringLength.stringLength(Coach_Name, 25);
				Superbowl      = StringLength.stringLength(Superbowl,   3);
				Team_Name      = StringLength.stringLength(Team_Name,  25);
				System.out.println(
				  "|||      Coach Name: "      + Coach_Name 
				+ "  Superbowl Wins: "  + Superbowl_Wins 
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
