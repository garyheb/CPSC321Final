package Functions;

import java.util.Scanner;

public class getMoreOrLess {
    public static String MoreOrLess(){
        Scanner scanner = new Scanner(System.in);
        String moreOrLess = "";
        System.out.println("Would you like to search by greater than or less than?: ");
        while(!moreOrLess.equals("<") && !moreOrLess.equals(">")){
            System.out.print("Please enter > or < to decide: ");
            moreOrLess = scanner.nextLine();
        }
        return moreOrLess;
    }
}
