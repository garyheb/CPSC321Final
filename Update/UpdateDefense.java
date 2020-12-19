package Update;

//imports
import java.io.*;
import java.sql.*;  
import java.util.Properties;
import java.util.Scanner;
import Functions.*;

public class UpdateDefense {
    public static void UpdateDefense(){

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

        //get team name from function
        System.out.println("For which team?");
        String teamName = getTeam.getTeam();

        //list the players so the user can decide which to update
        System.out.println();
        System.out.println("--- List of Defensive Players ---");
        String q = "SELECT * FROM Defensive_Player WHERE Season = " + Season + " AND Team_Name = " + teamName;
            ResultSet rs = stmt.executeQuery(q);
            // print results
            String Player_Name;
            while(rs.next()) {
                Player_Name = rs.getString("Player_Name");
                System.out.println(
                    "Player Name: " + Player_Name );
            }
        
        // get defense player name
        System.out.println();
        System.out.println();
        System.out.print("Which defensive player would you like to update:");
        Player_Name = scanner.nextLine();       

        stmt = con.createStatement();
        String updateStats = updateWhichStats();
        q = "UPDATE Defensive_Player SET " + updateStats.substring(0, updateStats.length()-2) + " WHERE Season = " + Season + " AND Player_Name = \"" + Player_Name + "\"" + " AND Team_Name = " + teamName;
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
        System.out.println("Update which stats?");
        while(doneUpdating == false){
            if(stat1 == false){
                System.out.println("1. Birthday");
            }
            if(stat2 == false){
                System.out.println("2. Jersey Number");
            }
            if(stat3 == false){
                System.out.println("3. Interceptions");
            }
            if(stat4 == false){
                System.out.println("4. Rushing Yards");
            }
            if(stat5 == false){
                System.out.println("5. Touchdowns");
            }
            if(stat6 == false){
                System.out.println("6. Sacks");
            }
            if(stat7 == false){
                System.out.println("7. Tackles");
            }
            System.out.println("8. Done Updating");
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
                Update = "Birthday = \"" + Birthday + "\", ";
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
                System.out.print("Please enter the number of interceptions: ");
                int interceptions = getInt.getInt();
                Update = "Interceptions = " + interceptions + ", ";
                break;
              case 4:
                System.out.print("Please enter the rushing yards: ");
                int rushingYards = getInt.getInt();
                Update = "Rushing_Yards = " + rushingYards + ", ";
                break;
              case 5:
                System.out.print("Please enter the number of touchdowns: ");
                int touchdowns = getInt.getInt();
                Update = "Touchdowns = " + touchdowns + ", ";
                break;
              case 6:
                System.out.print("Please enter the number of sacks: ");
                int sacks = getInt.getInt();
                Update = "Sacks = " + sacks + ", ";
                break;
              case 7:
                System.out.print("Please enter the number of tackles: ");
                int tackles = getInt.getInt();
                Update = "Tackles = " + tackles + ", ";
                break;
              default:
                return Update;
            }
            
            return Update;
          };
}
