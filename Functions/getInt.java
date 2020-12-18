package Functions;

//imports
import java.util.Scanner;

public class getInt {
    public static int getInt(){
        boolean intEntered = false;
        int enteredInt = 0;
        Scanner scanner = new Scanner(System.in);

        String Input = "";

        while(intEntered == false){
            Input = scanner.nextLine();
            try{    
                enteredInt = Integer.parseInt(Input);
                intEntered = true;
            }catch (NumberFormatException ex) {
                System.out.print("Please enter a number: ");
            }
        }
        return enteredInt;
    }
}
