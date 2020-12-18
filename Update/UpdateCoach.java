package Update;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class UpdateCoach {
    public static void UpdateCoach(){

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
        
        // get Team name from function
        System.out.print("Which Quarterback would you like to update:");
        String Player_Name = scanner.nextLine();

        //get season from function
        System.out.println("For which season?");
        int Season = getSeason.getSeason();        

        stmt = con.createStatement();
        String updateStats = updateWhichStats();
        String q = "UPDATE Quarterback SET Birthday = " + updateStats.substring(0, updateStats.length()-2) + " WHERE Season = " + Season + " AND Player_Name = \"" + Player_Name + "\"";
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
