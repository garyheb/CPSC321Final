package Filters;

//imports
import Functions.*;
import java.util.Scanner;

//team name, wins, losses, draws, superbowl
public class OPFilter {
	public static String OPFilter(){
        Scanner scanner = new Scanner(System.in);
        String yesNo = "";
        String Filter = "";
        boolean ynInput = false;

        System.out.println("Would you like to apply a filter?");        
        while(ynInput == false){
            System.out.print("Please enter y or n: ");
            yesNo = scanner.next();
            ynInput = yesNoInput.yesNoInput(yesNo);
        }

        if(yesNo.equals("y")){
            Filter = getFilter();
        }
        System.out.println("Test");
        return Filter;	   
    }

    public static String getFilter(){
        String  filter = "";
        boolean doneFiltering = false;
        boolean stat1 = false; 
        boolean stat2 = false;
        boolean stat3 = false; 
        boolean stat4 = false;
        System.out.println("Filter by which stats?");
        while(doneFiltering == false){
            if(stat1 == false){
                System.out.println("1. Touchdowns");
            }
            if(stat2 == false){
                System.out.println("2. Passing Yards");
            }
            if(stat3 == false){
                System.out.println("3. Rushing Yards");
            }
            if(stat4 == false){
                System.out.println("4. Turnovers");
            }                
            System.out.println("5. Done");
            System.out.print("Please select stat to filter:");
            int filterStat = getInt.getInt();
            if(filterStat == 1){
                stat1 = true;
            }
            if(filterStat == 2){
                stat2 = true;
            }
            if(filterStat == 3){
                stat3 = true;
            }
            if(filterStat == 4){
                stat4 = true;
            }
            if(filterStat == 5){
                doneFiltering = true;
            }
            filter += getStatsToFilter(filterStat);  
        }
        return filter;
      }
    
      public static String getStatsToFilter(int Input){
        String  temp = "";
        String  moreOrLess = "";
        int     value = 0;
        switch(Input) {
          case 1:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Touchdowns " + moreOrLess + " " + value;
            break;
          case 2:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Passing_Yards " + moreOrLess + " " + value;
            break;
          case 3:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Rushing_Yards " + moreOrLess + " " + value;
            break;
          case 4:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Turnovers " + moreOrLess + " " + value;
            break;
          
          default:
            return temp;
        }    
        return temp;
      };
}

