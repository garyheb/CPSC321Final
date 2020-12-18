package Functions;

public class getPassesCompleted {
    public static String PassesCompleted(){
        System.out.print("Please enter the number of passes completed: ");
        int PassesCompleted = getInt.getInt();
        String returnMe = String.valueOf(PassesCompleted);
        return returnMe;
    }
}
