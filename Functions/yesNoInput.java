package Functions;

public class yesNoInput {
    public static boolean yesNoInput(String yesNo){
        System.out.println("yesNo = " + yesNo);
        switch(yesNo){
            case "y":
                return true;
            case "n": 
                return true;
            default : 
                return false;
        }

    }
}
