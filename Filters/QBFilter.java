package Filters;

//imports
import Functions.*;
import java.util.Scanner;

//team name, wins, losses, draws, superbowl
public class QBFilter {
	public static String QBFilter(){
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
        return Filter;	   
    }

    public static String getFilter(){
        String  filter = "";
        boolean doneFiltering = false;
        boolean stat1 = false; 
        boolean stat2 = false;
        boolean stat3 = false; 
        boolean stat4 = false;
        boolean stat5 = false; 
        boolean stat6 = false;
        boolean stat7 = false; 
        boolean stat8 = false;
        boolean stat9 = false; 
        boolean stat10 = false;
        System.out.println("Filter by which stats?");
        while(doneFiltering == false){
            if(stat1 == false){
                System.out.println("1. Passing Yards");
            }
            if(stat2 == false){
                System.out.println("2. Rushing Yards");
            }
            if(stat3 == false){
                System.out.println("3. Times Sacked");
            }
            if(stat4 == false){
                System.out.println("4. Interceptions");
            }
            if(stat5 == false){
                System.out.println("5. Fumbles");
            }
            if(stat6 == false){
                System.out.println("6. Passing Touchdowns");
            }
            if(stat7 == false){
                System.out.println("7. Rushing Touchdowns");
            }
            if(stat8 == false){
                System.out.println("8. Completion Percentage");
            }        
            if(stat9 == false){
                System.out.println("9. Passes Attempted");
            }       
            if(stat10 == false){
                System.out.println("10. Passes Completed");
            }          
            System.out.println("11. Done");
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
                stat5 = true;
            }
            if(filterStat == 6){
                stat6 = true;
            }
            if(filterStat == 7){
                stat7 = true;
            }
            if(filterStat == 8){
                stat8 = true;
            }
            if(filterStat == 9){
                stat9 = true;
            }
            if(filterStat == 10){
                stat10 = true;
            }
            filter += getStatsToFilter(filterStat);  
            if(filterStat == 11){
                return filter;
            }
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
            temp = " AND Passing_Yards " + moreOrLess + " " + value;
            break;
          case 2:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Rushing_Yards " + moreOrLess + " " + value;
            break;
          case 3:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Times_Sacked " + moreOrLess + " " + value;
            break;
          case 4:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Interceptions " + moreOrLess + " " + value;
            break;
          case 5:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Fumbles " + moreOrLess + " " + value;
            break;
          case 6:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Passing_TD " + moreOrLess + " " + value;
            break;
          case 7:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Rushing_TD " + moreOrLess + " " + value;
            break;
          case 8:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Completion_Perc " + moreOrLess + " " + value;
            break;
          case 9:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Passes_Attempted " + moreOrLess + " " + value;
            break;        
          case 10:
            moreOrLess = getMoreOrLess.MoreOrLess();
            System.out.println("What value would you like to search by?");
            value = getInt.getInt();
            temp = " AND Passes_Completed " + moreOrLess + " " + value;
            break;
          case 11:
            return temp;   
          default:
            return temp;
        }    
        return temp;
      };
}

