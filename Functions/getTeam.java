package Functions;

public class getTeam {
    public static String getTeam(){
        
        String Team_Name = "Null";
        int    TeamInt   = 0;
        while(Team_Name == "Null"){
            System.out.println("1:  Arizona Cardinals");
            System.out.println("2:  Atlanta Falcons");
            System.out.println("3:  Baltimore Ravens");
            System.out.println("4:  Buffalo Bills");
            System.out.println("5:  Carolina Panthers");
            System.out.println("6:  Chicago Bears");
            System.out.println("7:  Cincinnati Bengals");
            System.out.println("8:  Cleveland Browns");
            System.out.println("9:  Dallas Cowboys");
            System.out.println("10: Denver Broncos");
            System.out.println("11: Detroit Lions");
            System.out.println("12: Green Bay Packers");
            System.out.println("13: Houston Texans");
            System.out.println("14: Indianapolis Colts");
            System.out.println("15: Jacksonville Jaguars");
            System.out.println("16: Kansas City Chiefs");
            System.out.println("17: Las Vegas Raiders");
            System.out.println("18: Los Angeles Chargers");
            System.out.println("19: Los Angeles Rams");
            System.out.println("20: Miami Dolphins");
            System.out.println("21: Minnesota Vikings");
            System.out.println("22: New England Patriots");
            System.out.println("23: New Orleans Saints");
            System.out.println("24: New York Giants");
            System.out.println("25: New York Jets");
            System.out.println("26: Philadelphia Eagles");
            System.out.println("27: Pittsburgh Steelers");
            System.out.println("28: San Fransisco 49ers");
            System.out.println("29: Seattle Seahawks");
            System.out.println("30: Tampa Bay Buccaneers");
            System.out.println("31: Tennessee Titans");
            System.out.println("32: Washington Football Team");           
            
            System.out.print("Please select desired team:");
            TeamInt     = getInt.getInt();
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
            Team_Name = "\"Baltimore Ravens\"";
            break;
          case 4:
            Team_Name = "\"Buffalo Bills\"";
            break;
          case 5:
            Team_Name = "\"Carolina Panthers\"";
            break;
          case 6:
            Team_Name = "\"Chicago Bears\"";
            break;
          case 7:
            Team_Name = "\"Cincinnati Bengals\"";
            break;
          case 8:
            Team_Name = "\"Cleveland Browns\"";
            break;
          case 9:
            Team_Name = "\"Dallas Cowboys\"";
            break;
          case 10:
            Team_Name = "\"Denver Broncos\"";
            break;
          case 11:
            Team_Name = "\"Detroit Lions\"";
            break;
          case 12:
            Team_Name = "\"Green Bay Packers\"";
            break;
          case 13:
            Team_Name = "\"Houston Texans\"";
            break;
          case 14:
            Team_Name = "\"Indianapolis Colts\"";
            break;
          case 15:
            Team_Name = "\"Jacksonville Jaguars\"";
            break;
          case 16:
            Team_Name = "\"Kansas City Chiefs\"";
            break;
          case 17:
            Team_Name = "\"Las Vegas Raiders\"";
            break;
          case 18:
            Team_Name = "\"Los Angeles Chargers\"";
            break;
          case 19:
            Team_Name = "\"Los Angeles Rams\"";
            break;
          case 20:
            Team_Name = "\"Miami Dolphins\"";
            break;
          case 21:
            Team_Name = "\"Minnesota Vikings\"";
            break;
          case 22:
            Team_Name = "\"New England Patriots\"";
            break;
          case 23:
            Team_Name = "\"New Orleans Saints\"";
            break;
          case 24:
            Team_Name = "\"New York Giants\"";
            break;
          case 25:
            Team_Name = "\"New York Jets\"";
            break;
          case 26:
            Team_Name = "\"Philadelphia Eagles\"";
            break;
          case 27:
            Team_Name = "\"Pittsburgh Steelers\"";
            break;
          case 28:
            Team_Name = "\"San Fransisco 49ers\"";
            break;
          case 29:
            Team_Name = "\"Seattle Seahawks\"";
            break;
          case 30:
            Team_Name = "\"Tampa Bay Buccaneers\"";
            break;
          case 31:
            Team_Name = "\"Tennessee Titans\"";
            break;
          case 32:
            Team_Name = "\"Washington Football Team\"";
            break;
          default:
            Team_Name = "Null";
        }
        
        return Team_Name;
      };
}
