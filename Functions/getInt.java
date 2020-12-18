package Functions;

//imports
import java.util.Scanner;

public class getInt {
    public static int getInt(){
        boolean intEntered = false;
        int enteredInt = 0;
        Scanner scanner = new Scanner(System.in);

        String Input = scanner.nextLine();

        while(intEntered == false){

            try{    
                enteredInt = Integer.parseInt(Input);
            }catch (NumberFormatException ex) {
                //handle exception here
            }
        }
        return enteredInt;
    }
}
