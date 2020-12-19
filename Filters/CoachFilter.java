package Filters;

//imports
import Functions.*;
import java.util.Scanner;

//team name, wins, losses, draws, superbowl
public class CoachFilter {
	public static String CoachFilter(){
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
        System.out.println("Filter by which stats?");
        while(doneFiltering == false){
            if(stat1 == false){
                System.out.println("1. Superbowl Wins");
            }           
            System.out.println("2. Done");
            System.out.print("Please select stat to filter:");
            int filterStat = getInt.getInt();
            if(filterStat == 1){
                stat1 = true;
            }
            if(filterStat == 2){
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
            temp = " AND Superbowl_Wins " + moreOrLess + " " + value;
            break;
          default:
            return temp;
        }    
        return temp;
      };
}

