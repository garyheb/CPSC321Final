package Functions;

public class getBirthday {
    public static String getBirthday(){
        String monthString = "";
        String dayString = "";
        System.out.println("Please enter the Birthday of the quarterback: ");
        System.out.print("What year was the quarterback born: ");
        int year = getInt.getInt();
        if(year < 1900 || year > 2020){
            System.out.print("Please enter a year between 1900 and 2020: ");
            year  = getInt.getInt();
        }            
        System.out.print("What month was the quarterback born: ");
        int month = getInt.getInt();
        if(month > 12 || month == 0){
            System.out.print("Please enter a valid month:");
            month = getInt.getInt();
        }
        if(month < 10){
            monthString = '0' + String.valueOf(month);
        }else{
            monthString = String.valueOf(month);
        }            
        System.out.print("What day was the quarterback born: ");
        int day   = getInt.getInt();
        if(day > 31 || day == 0){
            System.out.print("Please enter a valid day:");
            month = getInt.getInt();
        }
        if(day < 10){
            dayString = '0' + String. valueOf(day);
        }else{
            dayString = String.valueOf(day);
        }
        String birthday = year + "-" + monthString + "-" + dayString;
        birthday = "Birthday = \"" + birthday + "\", ";
        return birthday;
    }
}
