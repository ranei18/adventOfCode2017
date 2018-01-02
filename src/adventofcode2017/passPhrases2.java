package adventofcode2017;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class passPhrases2 {
    public static void main(String[] args){
        int counter = 0;
        try(FileReader file = new FileReader("passPhrases2.txt");
                BufferedReader buff = new BufferedReader(file)) {
            boolean eof = false;
                while(!eof){
                    String line = buff.readLine();
                    if(line == null) {
                        eof = true;
                    } else {
                        if (duplicateWords(line) && anagrams(line)){
                            counter++;
                        }
                    }
                }
           
        } catch(IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
        System.out.println(counter);
    }
    static boolean duplicateWords(String line){
        String regex = "\\b(\\w+)[\\w\\W]*(\\b\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(line);
        if(!m.find()){
            return true;
        } else {
            return false;
        }
    }
    
    static boolean anagrams(String line){
        ArrayList<String> anagram = new ArrayList();
        StringTokenizer words = new StringTokenizer(line," ");
        do {
            char tempArray[] = words.nextToken().toCharArray();
            Arrays.sort(tempArray);
            String test = new String(tempArray);
            if (anagram.contains(test)) {
                return false;
            } else {
                anagram.add(new String(tempArray));
            }
            
        } while (words.hasMoreElements());
        return true;
    }
    
    
}