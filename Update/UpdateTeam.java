package Update;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class UpdateTeam {
    public static void UpdateTeam(){

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

        // create and execute query
        Statement stmt = con.createStatement();
        
        // get Team name from function
        System.out.print("Which team would you like to update:");
        String teamName = getTeam.getTeam();

        //get season from function
        int season = getSeason.getSeason();        

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
        
        System.out.println("How many Super Bowls has your team won?");
        int sbWins = getInt.getInt();           

        stmt = con.createStatement();
        String q = "UPDATE Team SET Wins = " + wins + ", Losses = " + losses + ", Draws = " + draws + ", Superbowl_Wins = " + sbWins + " WHERE Season = " + season + " AND Team_Name = " + teamName;
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
