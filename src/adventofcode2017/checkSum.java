
import java.util.*;
import java.io.*;


public class checkSum{
    public static void main(String[] args){
        
        int total = 0;
        
        try(FileReader file = new FileReader("checkSum.txt");
                BufferedReader buff = new BufferedReader(file)){
            boolean eof = false;
            while(!eof){
                String line = buff.readLine();
                if(line == null){
                    eof = true;
                } else {
                    StringTokenizer row = new StringTokenizer(line,"\t");
                    int min = Integer.MAX_VALUE;
                    int max = 0;
                    int cur;
                    while (row.hasMoreElements()){
                        cur = Integer.parseInt(row.nextToken());
                        if(cur > max){
                            max = cur; 
                        } else if (cur < min) {
                            min = cur;
                        } 
                    }
                    total += max - min;
                }
            }
            buff.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
        System.out.println(total); 
    }
}