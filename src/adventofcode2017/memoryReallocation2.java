package adventofcode2017;

import java.util.*;
import java.io.*;

//Refactor me please...
public class memoryReallocation2 {
    public static void main(String[] args){
        //store memory banks
        Integer[] block = new Integer[16];
        //store history of memory allocation
        ArrayList<Integer[]> history = new ArrayList<Integer[]>();
        
        //load memoryReallocation.txt file
        try(FileReader file = new FileReader("memoryReallocation.txt");
                BufferedReader buff = new BufferedReader(file)) {
        boolean eof = false;
        int i = 0;
        while (!eof){
            String line = buff.readLine();
            if(line != null) {
                block[i] = Integer.parseInt(line);
                i++;
            } else {
                eof = true;
            }    
        }  
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }
        boolean match = false;
        int startIndex;
        int count = 0;
        
        System.out.print("block: "); 
            for (int x = 0; x < block.length; x++){
                
            System.out.print(block[x] + " ");
               
            }
            System.out.println();
        
        while (!match){
            startIndex = findMax(block);
            System.out.println("max index: " + startIndex + " value: " + block[startIndex]);
            int maxValue = block[startIndex];
            block[startIndex] = 0;
            int loc = startIndex;
            for (int i = 0; i < maxValue; i++){
                loc++;
                System.out.println("current block: " + loc);
                if(loc >= block.length){
                    loc = 0;
                    block[loc] = block[loc] + 1;
                } else {
                    block[loc] = block[loc] + 1;
                }
            }
            System.out.print("block: "); 
            for (int x = 0; x < block.length; x++){
                
            System.out.print(block[x] + " ");
               
            }
            System.out.println();
            count++;
            match = checkHistory(block, history);
            storeHistory(block,history);
        }
        
        System.out.println(count);
        
        

        
    }
    
    public static void redistribute(Integer[] block){
      
    }
    
    public static int findMax(Integer[] block) {
        //returns the index of the max value
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < block.length ; i++) {
            if (block[i] > maxValue) {
                maxIndex = i;
                maxValue = block[i];
            }
        }
        return maxIndex;
    }
    
    public static void storeHistory(Integer[] block, ArrayList<Integer[]> history){
        /*
        Integer[] temp = new Integer[16];
        for (int i = 0; i < block.length; i++){
            temp[i] = block[i];
        }
        */
        Integer[] temp = Arrays.copyOf(block, 16);
        history.add(temp);
    }
    
    public static boolean checkHistory(Integer[] block, ArrayList<Integer[]> history){
        boolean match = false;
        int counter = 0;
        for (Integer[] i : history){
            counter++;
            if (Arrays.equals(block, i)){
                match = true;
                System.out.println(counter);
            }
        }
        return match;
    }

}
