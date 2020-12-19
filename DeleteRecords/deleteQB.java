package DeleteRecords;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class deleteQB {
    public static void deleteQB(){

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
        System.out.println("--- List of Quarterbacks ---");
        String q = "SELECT * FROM Quarterback WHERE Season = " + Season;
            ResultSet rs = stmt.executeQuery(q);
            // print results
            String Player_Name;
            while(rs.next()) {
                Player_Name = rs.getString("Player_Name");
                System.out.println(
                    "Player Name: " + Player_Name );
            }
        
        // get Team name from function
        System.out.println();
        System.out.println();
        System.out.print("Please type the first and last name of the player you would like to delete:");
        Player_Name = scanner.nextLine();        

        stmt = con.createStatement();
        q = "DELETE FROM Quarterback WHERE Player_Name = \"" + Player_Name + "\" AND Season = " + Season;
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