package Functions;

public class getJerseyNumber {
    public static String getJerseyNumber(){
        System.out.print("Please enter the jersey number: ");
        int jerseyNumber = getInt.getInt();
        if(jerseyNumber > 99){
          System.out.println("Please enter a jersey number < 100");
          jerseyNumber = getInt.getInt();
        }
        String returnMe = String.valueOf(jerseyNumber);
        return returnMe;
    }
}
