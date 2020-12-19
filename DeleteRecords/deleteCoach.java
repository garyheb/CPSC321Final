package DeleteRecords;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class deleteCoach {
    public static void deleteCoach(){

        try {

        Scanner scanner = new Scanner(System.in);

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

        // create and execute query
        Statement stmt = con.createStatement();

        //get season from function
        int Season = getSeason.getSeason();  
        
        //list the coaches so the user can decide which to delete
        System.out.println();
        System.out.println("--- List of coaches ---");
        String q = "SELECT * FROM Head_Coach WHERE Season = " + Season;
			ResultSet rs = stmt.executeQuery(q);
            String Coach_Name, Superbowl = "";
			// print results
			while(rs.next()) {
				Coach_Name     = rs.getString("Coach_Name");
				System.out.println(
				  "Coach Name: " + Coach_Name );
            }
        
        // get Team name from function
        System.out.println();
        System.out.println();
        System.out.print("Please type the first and last name of the coach you would like to delete:");
        Coach_Name = scanner.nextLine();     

        stmt = con.createStatement();
        q = "DELETE FROM Head_Coach WHERE Coach_Name = \"" + Coach_Name + "\" AND Season = " + Season;
        stmt.executeUpdate(q);

        //releases resources
        stmt.close();
        con.close();

        }
        catch(Exception e) {
			System.out.println(e);
		}
    }
}

    