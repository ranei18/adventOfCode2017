
import java.util.*;
import java.io.*;

public class checkSum2{
    public static void main(String[] args) {
        int output = 0;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        
        try(FileReader file = new FileReader("checkSum2.txt");
                BufferedReader buff = new BufferedReader(file)){
            int diff = 0;
            
            boolean eof = false;
            while(!eof){
                
                String line = buff.readLine();
                if(line == null) {
                    eof = true;
                } else {
                    ArrayList<Integer> rowItems = new ArrayList<Integer>();
                    StringTokenizer nums = new StringTokenizer(line,"\t");
                    while(nums.hasMoreElements()){
                        rowItems.add(Integer.parseInt(nums.nextToken()));
                    }

                for (int y : rowItems){
                    for (int x : rowItems){
                        if(y%x == 0 && y/x != 1){
                            diff =  y/x;
                            rows.add(diff);
                        }
                    }
                }   
                }
            }
            for (int i : rows) {
                output += i;
            }
            buff.close();
        } catch (IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }
        System.out.println(output);
        
    }
}