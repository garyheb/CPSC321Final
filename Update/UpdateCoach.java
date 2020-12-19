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

        //get season from function
        int Season = getSeason.getSeason();  

        //list the coaches so the user can decide which to update
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
        
        // get coaches name from function
        System.out.println();
        System.out.println();
        System.out.print("Please type the first and last name of the coach you would like to update:");
        String coachName = scanner.nextLine();      

        stmt = con.createStatement();
        String updateStats = updateWhichStats();
        q = "UPDATE Head_Coach SET " + updateStats.substring(0, updateStats.length()-2) + " WHERE Season = " + Season + " AND Coach_Name = \"" + coachName + "\"";
        stmt.executeUpdate(q);

        //releases resources
        stmt.close();
        con.close();

        }
        catch(Exception e) {
			System.out.println(e);
		}
    }

  public static String updateWhichStats(){
    String Update = "";
    boolean doneUpdating = false;
    boolean stat1 = false; 
    boolean stat2 = false;
    System.out.println("Update which stats?");
    while(doneUpdating == false){
        if(stat1 == false){
            System.out.println("1. Team Name");
        }
        if(stat2 == false){
            System.out.println("2. Superbowl Wins");
        }        
        System.out.println("3. Done Updating");
        System.out.print("Please select stat to update:");
        int updateStat = getInt.getInt();
        if(updateStat == 1){
            stat1 = true;
        }
        if(updateStat == 2){
            stat2 = true;
        }
        if(updateStat == 3){
            doneUpdating = true;
        }
        Update += getStatsToUpdate(updateStat);  
    }
    return Update;
  }

  public static String getStatsToUpdate(int Input){
    Scanner scanner = new Scanner(System.in);
    String Update = "";
    int year = 0;
    switch(Input) {
      case 1:
        String teamName = getTeam.getTeam();
        Update = "Team_Name = " + teamName + ", ";
        break;
      case 2:
        System.out.print("Please enter the number of superbowl wins: ");
        int superbowlWins = getInt.getInt();
        if(superbowlWins > 20){
          System.out.println("Please enter a number of wins that is less than 21");
          superbowlWins = getInt.getInt();
        }
        Update = "Superbowl_Wins = " + superbowlWins + ", ";
        break;
      
      default:
        return Update;
    }    
    return Update;
  };
}
