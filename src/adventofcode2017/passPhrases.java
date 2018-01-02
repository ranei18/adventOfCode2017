
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passPhrases {
    public static void main(String[] args){
        int valid = 0;
        String regex = "\\b(\\w+)[\\w\\W]*(\\b\\1\\b)+";
        
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        try(FileReader file = new FileReader("passPhrases.txt");
                BufferedReader buff = new BufferedReader(file)){
            boolean eof = false;
            while(!eof){
                String line = buff.readLine();
                if(line == null){
                    eof = true;
                } else{
                    //line = test;
                    Matcher m = p.matcher(line);
                    if(!m.find()){
                        System.out.println(line);
                        valid++;
                    } 
                }
            }
            
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
        System.out.println(valid);
    }
}