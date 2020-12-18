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
        while(doneUpdating == false){
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
            if(updateStat == 1){
                stat1 = true;
            }
            if(updateStat == 2){
                stat2 = true;
            }
            if(updateStat == 3){
                stat3 = true;
            }
            if(updateStat == 4){
                stat4 = true;
            }
            if(updateStat == 5){
                stat5 = true;
            }
            if(updateStat == 6){
                stat6 = true;
            }
            if(updateStat == 7){
                stat7 = true;
            }
            if(updateStat == 8){
                stat8 = true;
            }
            if(updateStat == 9){
                stat9 = true;
            }
            if(updateStat == 10){
                stat10 = true;
            }
            if(updateStat == 11){
                stat11 = true;
            }
            if(updateStat == 12){
                stat12 = true;
            }
            if(updateStat == 13){
                doneUpdating = true;
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
            year = getInt.getInt();
            if(year < 1900 || year > 2020){
                System.out.print("Please enter a year between 1900 and 2020: ");
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
                System.out.print("Please enter a valid day:");
                month = getInt.getInt();
            }
            if(day < 10){
                dayString = '0' + String. valueOf(day);
            }else{
                dayString = String.valueOf(day);
            }
            
            String Birthday = year + "-" + monthString + "-" + dayString;
            Update = "Birthday = " + Birthday + ", ";
            break;
          case 2:
            System.out.print("Please enter the jersey number: ");
            int jerseyNumber = getInt.getInt();
            if(jerseyNumber > 99){
              System.out.println("Please enter a jersey number < 100");
              jerseyNumber = getInt.getInt();
            }
            Update = "Jersey_Number = " + jerseyNumber + ", ";
            break;
          case 3:
            System.out.print("Please enter the passing yards: ");
            int passingYards = getInt.getInt();
            Update = "Passing_Yards = " + passingYards + ", ";
            break;
          case 4:
            System.out.print("Please enter the rushing yards: ");
            int rushingYards = getInt.getInt();
            Update = "Rushing_Yards = " + rushingYards + ", ";
            break;
          case 5:
            System.out.print("Please enter the times sacked: ");
            int timesSacked = getInt.getInt();
            Update = "Times_Sacked = " + timesSacked + ", ";
            break;
          case 6:
            System.out.print("Please enter the number of interceptions: ");
            int interceptions = getInt.getInt();
            Update = "Interceptions = " + interceptions + ", ";
            break;
          case 7:
            System.out.print("Please enter the number of fumbles: ");
            int fumbles = getInt.getInt();
            Update = "Fumbles = " + fumbles + ", ";
            break;
          case 8:
            System.out.print("Please enter the number of passing touchdowns: ");
            int passingTouchdowns = getInt.getInt();
            Update = "Passing_TD = " + passingTouchdowns + ", ";
            break;
          case 9:
            System.out.print("Please enter the rushing touchdowns: ");
            int rushingTDs = getInt.getInt();
            Update = "Rushing_TD = " + rushingTDs + ", ";
            break;
          case 10:
            System.out.print("Please enter the rushing yards: ");
            int completionPerc = getInt.getInt();
            Update = "Completion_Perc = " + completionPerc + ", ";
            break;
          case 11:
            System.out.print("Please enter the rushing yards: ");
            int passesAttempted = getInt.getInt();
            Update = "Passes_Attempted = " + passesAttempted + ", ";
            break;
          case 12:
            System.out.print("Please enter the rushing yards: ");
            int passesCompleted = getInt.getInt();
            Update = "Passes_Completed = " + passesCompleted + ", ";
            break;
          
          default:
            return Update;
        }
        
        return Update;
      };
}


