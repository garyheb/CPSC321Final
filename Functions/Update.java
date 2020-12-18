//imports
import java.io.*;
import java.util.Scanner;
import java.sql.*;  
import java.util.Properties;



public class Update {
    static String Input;
    		// List Tables to View

        
        public static String Option3(){


            }

            return q;
        }




        public static String Option4Teams(){
            
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

            String teamName = getTeam.getTeam();

            //need a seaspn function
            String query = "update team set wins = " + wins + "set losses = " + losses + " set superbowl_wins = " + sbWins  + "where season = " + season ;
            
            



            scanner.close();
            return query;
        }

        public static String Option4QB(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the name of the quarterback you wish to update");
            String qbname = scanner.nextLine();
            //get season menu
            int seasonInt = getSeason.getSeason();
            String season = getSeason.getSeasonString(seasonInt);





            //Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the number of Passing yards");
            int PY = scanner.nextLine();
            
            System.out.println("Please enter the number of rushing yards"); 
            int RY = scanner.nextLine();
            System.out.println("Please enter the number of times sacked");
            int losses = scanner.nextLine();
            System.out.println("Please enter the number of interceptions thrown");
            int interceptions = scanner.nextLine();
            System.out.println("Please enter the number of fumbles");
            int fumbles = scanner.nextLine();
            System.out.println("Please enter the number of passing touchdowns");
            int passing_TD = scanner.nextLine();
            System.out.println("Please enter the number of rushing touchdowns");
            int rushing_TD = scanner.nextLine();
            System.out.println("How many Super Bowls has your team won?");
            int sbWins = scanner.nextLine();
            System.out.println("Please enter the number passes attempted");
            int pass_attempt = scanner.nextLine();
            System.out.println("Please enter the number passes completed");
            int pass_comp = scanner.nextLine();
            while(pass_comp > pass_attempt){
                System.out.println("passes completed cannot exed passes attempted");
                pass_comp = scanner.nextLine();
            }
            Double pass_perc = (pass_comp/pass_attempt) * 100;
            System.out.println("Please enter theteam name");  
            String team_name = scanner.nextLine();


            //need a seaspn function
            String query = "update quarterback set  Passing_Yards = " + PY + "set Rushing_Yards = " + RY + " set Interceptions = " + interceptions  + " set Passing_TD = " + passing_TD  + " set Rushing_TD = " + rushing_TD  + " set Completion_Perc = " + pass_perc + " set Passes_Attempted = " + pass_attempt  + " set Passes_Completed = " + pass_comp  + "where season = " + season + "AND Player_Name = " + qbname;

            //scanner.close();
            return query; 
        }

        public static String Option4OP(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the name of the Offensive player you wish to update");
            String name = scanner.nextLine();
            int seasonInt = getSeason.getSeason();
            String season = getSeason.getSeasonString(seasonInt);
            System.out.println("Please enter the number touchdowns");
            int TD = scanner.nextLine();
            System.out.println("Please enter the number of passing yard");
            int pass_yards = scanner.nextLine();
            System.out.println("Please enter the number of rushing yard");
            int rush_yards = scanner.nextLine();
            System.out.println("Please enter the number of turnovers");
            int turnovers = scanner.nextLine();

            //need a seaspn function
            String query = "update Offensive_Player set  Touchdowns = " + TD + "set Rushing_Yards = " + rush_yards + " set Passing_Yards = " + pass_yards  + " set Rushing_TD = " + rushing_TD  + " set Turnovers = " + turnovers +  "where season = " + season + "AND Player_Name = " + name;

            return query;
            //scanner.close();
        }

        public static String Option4DP(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the name of the defensive player you wish to update");
            String name = scanner.nextLine();
            
            int seasonInt = getSeason.getSeason();
            String season = getSeason.getSeasonString(seasonInt);
            System.out.println("Please enter the number touchdowns");
            int TD = scanner.nextLine();
            System.out.println("Please enter the number of rushing yard");
            int rush_yards = scanner.nextLine();
            System.out.println("Please enter the number of sacks");
            int sacks = scanner.nextLine();
            System.out.println("Please enter the number of tackles");
            int tackles = getInt.getInt();
            System.out.println("Please enter the number of interceptions");
            int interceptions = getInt.getInt();

            //need a seaspn function
            String query = "update Defensive_Player set  Touchdowns = " + TD + "set Rushing_Yards = " + rush_yards + " set Sacks = " + sacks  + " set tackles = " + tackles  + " set Interceptions = " + interceptions +  "where season = " + season + "AND Player_Name = " + name;

           
            return query;
            //scanner.close();
        }

        public static String Option4HC(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the name of the head coach you wish to update");
            String name = scanner.nextLine();
            
            
            int seasonInt = getSeason.getSeason();
            String season = getSeason.getSeasonString(seasonInt);
            System.out.println("Please enter the number of Superbowl Wins");
            int SB_wins = getInt.getInt();

            String query = "update Head_Coach set  Superbowl_Wins = " + SB_wins +  "where season = " + season + "AND Player_Name = " + name;
            scanner.close();
            return query;

        }

        public static void Option4Exit(){
            FinalProject.MainMenu();
        }        
    }







