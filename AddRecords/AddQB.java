package AddRecords;

//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;
import Functions.*;

public class AddQB {
   public static void AddPlayer(){
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
        System.out.print("Please choose the season:");
        int SeasonName        = getSeason.getSeason();
        String season = String.valueOf(SeasonName);
        String teamName       = getTeam.getTeam();
        System.out.print("Please enter Player Name: ");
        String Player_Name    = scanner.nextLine();

        //get birthday
        String birthday = getBirthday.getBirthday();   
        
        //get jersey number
        String jerseyNumber = getJerseyNumber.getJerseyNumber();
        
        //get passing yards
        String passingYards = getPassingYards.passingYards();

        //get rushing yards
        String rushingYards = getRushingYards.rushingYards();

        //get sacks
        String sacks        = getSacks.sacks();

        //get interceptions
        String interceptions = getInterceptions.interceptions();

        //get fumbles
        String fumbles = getFumbles.Fumbles();

        //get passingTD
        String passingTD = getPassingTD.PassingTD();

        //get rushingTD
        String rushingTD = getRushingTD.RushingTD();

        //get completion percentage
        String completionPerc  = getCompletionPerc.CompletionPerc();

        //get passes attempted
        String passAttempt     = getPassesAttempted.PassesAttempted();

        //get passes completed
        String passesCompleted = getPassesCompleted.PassesCompleted();

        String position = "Quarterback";

        // create and execute query
        Statement stmt = con.createStatement();
        String q = "INSERT INTO Quarterback VALUES ('" + Player_Name + "', '" + "\"" + birthday + "\", " + jerseyNumber + ", " + passingYards + ", " + rushingYards + ", " + sacks + ", " + interceptions  + ", " +  fumbles  + ", " +  passingTD  + ", " +  rushingTD  + ", " +  completionPerc  + ", " +  passAttempt  + ", " +  passesCompleted  + ", \"" +  position  + ", \"" + season + ", " + teamName + ");";
        stmt.executeUpdate(q);


        q = "SELECT * FROM Quarterback WHERE Season = " + SeasonName + " ORDER BY Team_Name";
        ResultSet rs = stmt.executeQuery(q);
        String Season = "";
        // print results
        while(rs.next()) {
            Player_Name    = rs.getString("Player_Name");
            jerseyNumber   = rs.getString("Jersey_Number");
            Season         = rs.getString("Season");
            teamName       = rs.getString("Team_Name");
            System.out.println(
              "|||      Player Name: "      + Player_Name
            + "  Jersey Number: "   + jerseyNumber
            + "  Season: "          + Season
            + "  Team Name : "      + teamName  + "  |||");
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
