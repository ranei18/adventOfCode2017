
public class inverseCaptcha2 {
    public static void main(String[] args) {
        String input = args[0];
        int counter = 0;
        int index;
        int len = input.length();
        for (int i = 0; i < len; i++){
            //System.out.println(i);
            //System.out.println(i + len/2);
            if (i + (len/2) < len) {
                index = i + len/2;
                //System.out.println(index);
                if(input.charAt(i) == input.charAt(index)) {
                    counter += Character.getNumericValue(input.charAt(i));
                    //System.out.println(counter);
                }    
            } else {
                index = (i + len/2) - len;
                if(input.charAt(i) == input.charAt(index)){
                    counter += Character.getNumericValue(input.charAt(i));
                    //System.out.println(counter);
                }
            }
            
        
    } System.out.println(counter);
}
    
}
