package DeleteRecords;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class deleteDP {
    public static void deleteDP(){

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
        System.out.print("Which Defensive player would you like to delete:");
        String Player_Name = scanner.nextLine();

        //get season from function
        int Season = getSeason.getSeason();        

        stmt = con.createStatement();
        String q = "DELETE FROM Defensive_Player WHERE Player_Name = \"" + Player_Name + "\" AND Season = " + Season;
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