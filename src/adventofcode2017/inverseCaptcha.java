import java.util.*;

public class inverseCaptcha {
    public static void main(String[] args) {
        String input = args[0];
        int counter = 0;
        for (int i = 0; i < input.length()-1; i++){
            if(input.charAt(i) == input.charAt(i+1)) {
                counter += Character.getNumericValue(input.charAt(i));
            }  
        }
        if(input.charAt(0) == input.charAt(input.length()-1)){
            counter += Character.getNumericValue(input.charAt(0));
        }
        System.out.println(counter);
    }
}