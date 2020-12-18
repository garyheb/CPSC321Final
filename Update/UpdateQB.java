package Update;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class UpdateQB {
    public static void UpdateQB(){

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
        int Season = getSeason.getSeason();        

        

        System.out.println("Please enter the jersey number: ");
        int jerseyNumber = getInt.getInt();
        
        System.out.println("Please enter the passing yards: ");
        int passingYards = getInt.getInt();

        System.out.println("Please enter the rushing yards: ");
        int rushingYards = getInt.getInt();

        System.out.println("Please enter the times sacked: ");
        int timesSacked = getInt.getInt();

        System.out.println("Please enter the number of interceptions: ");
        int interceptions = getInt.getInt();

        System.out.println("Please enter the number of fumbles: ");
        int fumbles = getInt.getInt();

        System.out.println("Please enter the number of passing touchdowns: ");
        int passingTouchdowns = getInt.getInt();

        System.out.println("Please enter the number of rushing touchdowns: ");
        int rushingTouchdowns = getInt.getInt();

        System.out.println("Please enter the completion percentage: ");
        int completionPercentage = getInt.getInt();

        System.out.println("Please enter the passes attempted: ");
        int passesAttempted = getInt.getInt();

        System.out.println("Please enter the passes completed: ");
        int passesCompleted = getInt.getInt();

        stmt = con.createStatement();
        String q = "UPDATE Quarterback SET Birthday = " + Birthday + ", Losses = " + losses + ", Draws = " + draws + ", Superbowl_Wins = " + sbWins + " WHERE Season = " + season + " AND Team_Name = " + teamName;
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
        boolean stat3 = false;
        boolean stat4 = false;
        boolean stat5 = false;
        boolean stat6 = false;
        boolean stat7 = false;
        boolean stat8 = false;
        boolean stat9  = false;
        boolean stat10 = false;
        boolean stat11 = false;
        boolean stat12 = false;
        System.out.println("Update which stats?");
        while(doneUpdating = false){
            if(stat1 == false){
                System.out.println("1. Birthday");
            }
            if(stat2 == false){
                System.out.println("2. Jersey Number");
            }
            if(stat3 == false){
                System.out.println("3. Passing Yards");
            }
            if(stat4 == false){
                System.out.println("4. Rushing Yards");
            }
            if(stat5 == false){
                System.out.println("5. Times Sacked");
            }
            if(stat6 == false){
                System.out.println("6. Interceptions");
            }
            if(stat7 == false){
                System.out.println("7. Fumbles");
            }
            if(stat8 == false){
                System.out.println("8. Passing Touchdowns");
            }
            if(stat9 == false){
                System.out.println("9. Rushing Touchdowns");
            }
            if(stat10 == false){
                System.out.println("10. Completion Percentage");
            }
            if(stat11 == false){
                System.out.println("11. Passes Attempted");
            }
            if(stat12 == false){
                System.out.println("12. Passes Completed");
            }
            System.out.println("13. Done Updating");
            int updateStat = getInt.getInt();
            if(updateStat == 13){
                return Update;
            }
            else{
                Update += getStatsToUpdate(updateStat);
            }
            
        }
        return Update;
    }

    public static String getStatsToUpdate(int Input){
        Scanner scanner = new Scanner(System.in);
        String Update = "";
        int year = 0;
        switch(Input) {
          case 1:
            String monthString = "";
            String dayString = "";
            System.out.println("Please enter the Birthday of the quarterback: ");
            System.out.print("What year was the quarterback born: ");
            while(year < 1900 || year > 2020){
                year  = getInt.getInt();
            }            
            System.out.print("What month was the quarterback born: ");
            int month = getInt.getInt();
            if(month > 12 || month == 0){
                System.out.print("Please enter a valid month:");
                month = getInt.getInt();
            }
            if(month < 10){
                monthString = '0' + String.valueOf(month);
            }else{
                monthString = String.valueOf(month);
            }            
            System.out.print("What day was the quarterback born: ");
            int day   = getInt.getInt();
            if(day > 31 || day == 0){
                System.out.print("Please enter a valid month:");
                month = getInt.getInt();
            }
            if(day < 10){
                dayString = '0' + String. valueOf(day);
            }else{
                dayString = String.valueOf(day);
            }
            
            String Birthday = year + "-" + monthString + "-" + dayString;
            Update += "Birthday = " + Birthday + ", ";
            break;
          case 2:
            System.out.print("Please enter the jersey number: ");
            int jerseyNumber = getInt.getInt();
            if(jerseyNumber > 99){
              System.out.println("Please enter a jersey number < 100");
              jerseyNumber = getInt.getInt();
            }
            Update += "Jersey_Number = " + jerseyNumber + ", ";
            break;
          case 3:
            System.out.print("Please enter the passing yards: ");
            int passingYards = getInt.getInt();
            Update += "Passing_Yards = " + passingYards + ", ";
            break;
          case 4:
            System.out.print("Please enter the rushing yards: ");
            int rushingYards = getInt.getInt();
            Update += "Rushing_Yards = " + rushingYards + ", ";
            break;
          case 5:
            Season = 2015;
            break;
          case 6:
            Season = 2016;
            break;
          case 7:
            Season = 2017;
            break;
          case 8:
            Season = 2018;
            break;
          case 9:
            Season = 2019;
            break;
          case 10:
            Season = 2020;
            break;
          
          default:
            Season = 0;
        }
        
        return Season;
      };
}


