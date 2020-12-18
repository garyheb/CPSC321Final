package Functions;

public class StringLength {
    //ensures that the strings are of the same length.  That makes the console log look a lot better
	public static String stringLength(String output, int length){
	   
        while(output.length() < length){
             output += " ";
        }
        return output;	   
     }
}
