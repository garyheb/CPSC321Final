package Functions;

public class getSeason {
    public static int getSeason(){
        
        int    Season  = 0;
        while(Season == 0){
            System.out.println("1:  2011");
            System.out.println("2:  2012");
            System.out.println("3:  2013");
            System.out.println("4:  2014");
            System.out.println("5:  2015");
            System.out.println("6:  2016");
            System.out.println("7:  2017");
            System.out.println("8:  2018");
            System.out.println("9:  2019");
            System.out.println("10: 2020");
            System.out.print("Please select the season:");
            Season      = getInt.getInt();
            Season      = getSeasonString(Season);
        }
        return Season;
    }

    public static int getSeasonString(int Input){
        int Season = 0;
        switch(Input) {
          case 1:
            Season = 2011;
            break;
          case 2:
            Season = 2012;
            break;
          case 3:
            Season = 2013;
            break;
          case 4:
            Season = 2014;
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

