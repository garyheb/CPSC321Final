package Functions;

//imports
import java.util.Scanner;

public class getTeam {
    public static String getTeam(){
        Scanner scanner = new Scanner(System.in);
        
        String Team_Name = "Null";
        int    TeamInt   = 0;
        String Input = "";
        while(Team_Name == "Null"){
            System.out.println("1:  Arizona Cardinals");
            System.out.println("2:  Atlanta Falcons");
            System.out.println("3:  Carolina Panthers");
            System.out.println("4:  Chicago Bears");
            System.out.println("5:  Dallas Cowboys");
            System.out.println("6:  Detroit Lions");
            System.out.println("7:  Green Bay Packers");
            System.out.println("8:  Los Angeles Rams");
            System.out.println("9:  Minnesota Vikings");
            System.out.println("10: New Orleans Saints");
            System.out.println("11: New York Giants");
            System.out.println("12: Philadelphia Eagles");
            System.out.println("13: San Fransisco 49ers");
            System.out.println("14: Seattle Seahawks");
            System.out.println("15: Tampa Bay Buccaneers");
            System.out.println("16: Washington Football Team");
            System.out.println("17: Baltimore Ravens");
            System.out.println("18: Buffalo Bills");
            System.out.println("19: Cincinnati Bengals");
            System.out.println("20: Cleveland Browns");
            System.out.println("21: Denver Broncos");
            System.out.println("22: Houston Texans");
            System.out.println("23: Indianapolis Colts");
            System.out.println("24: Jacksonville Jaguars");
            System.out.println("25: Kansas City Chiefs");
            System.out.println("26: Las Vegas Raiders");
            System.out.println("27: Los Angeles Chargers");
            System.out.println("28: Miami Dolphins");
            System.out.println("29: New England Patriots");
            System.out.println("30: New York Jets");
            System.out.println("31: Pittsburgh Steelers");
            System.out.println("32: Tennessee Titans");
            System.out.print("Please enter the teams number that you wish to view:");
            Input       = scanner.nextLine();
            TeamInt     = Integer.parseInt(Input);
            Team_Name   = getTeam_Name(TeamInt);
        }
        return Team_Name;
    }

    public static String getTeam_Name(int Input){
        String Team_Name = "";
        switch(Input) {
          case 1:
            Team_Name = "\"Arizona Cardinals\"";
            break;
          case 2:
            Team_Name = "\"Atlanta Falcons\"";
            break;
          case 3:
            Team_Name = "\"Carolina Panthers\"";
            break;
          case 4:
            Team_Name = "\"Chicago Bears\"";
            break;
          case 5:
            Team_Name = "\"Dallas Cowboys\"";
            break;
          case 6:
            Team_Name = "\"Detroit Lions\"";
            break;
          case 7:
            Team_Name = "\"Green Bay Packers\"";
            break;
          case 8:
            Team_Name = "\"Los Angeles Rams\"";
            break;
          case 9:
            Team_Name = "\"Minnesota Vikings\"";
            break;
          case 10:
            Team_Name = "\"New Orleans Saints\"";
            break;
          case 11:
            Team_Name = "\"New York Giants\"";
            break;
          case 12:
            Team_Name = "\"Philadelphia Eagles\"";
            break;
          case 13:
            Team_Name = "\"San Fransisco 49ers\"";
            break;
          case 14:
            Team_Name = "\"Seattle Seahawks\"";
            break;
          case 15:
            Team_Name = "\"Tampa Bay Buccaneers\"";
            break;
          case 16:
            Team_Name = "\"Washington Football Team\"";
            break;
          case 17:
            Team_Name = "\"Baltimore Ravens\"";
            break;
          case 18:
            Team_Name = "\"Buffalo Bills\"";
            break;
          case 19:
            Team_Name = "\"Cincinnati Bengals\"";
            break;
          case 20:
            Team_Name = "\"Cleveland Browns\"";
            break;
          case 21:
            Team_Name = "\"Denver Broncos\"";
            break;
          case 22:
            Team_Name = "\"Houston Texans\"";
            break;
          case 23:
            Team_Name = "\"Indianapolis Colts\"";
            break;
          case 24:
            Team_Name = "\"Jacksonville Jaguars\"";
            break;
          case 25:
            Team_Name = "\"Kansas City Chiefs\"";
            break;
          case 26:
            Team_Name = "\"Las Vegas Raiders\"";
            break;
          case 27:
            Team_Name = "\"Los Angeles Chargers\"";
            break;
          case 28:
            Team_Name = "\"Miami Dolphins\"";
            break;
          case 29:
            Team_Name = "\"New England Patriots\"";
            break;
          case 30:
            Team_Name = "\"New York Jets\"";
            break;
          case 31:
            Team_Name = "\"Pittsburgh Steelers\"";
            break;
          case 32:
            Team_Name = "\"Tennessee Titans\"";
            break;
          default:
            Team_Name = "Null";
        }
        
        return Team_Name;
      };
}
