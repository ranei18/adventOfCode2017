package adventOfCode2017;

import java.util.*;
import java.io.*;

public class trampolineMaze2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = getList("maze.txt");    
        int position = 0;
        int positionValue;
        int nextPosition;
        int jumps = 0;
        int mazeLength = list.size() -1;
        boolean end = false;
        
        while (!end) {
            positionValue = list.get(position);
            nextPosition = positionValue + position;
            jumps++;
            //System.out.print("Position: " + position + " Value: " + positionValue + " NextPosition: " + nextPosition + "\n");
            if (nextPosition > mazeLength){
                end = true;
                System.out.println(jumps);
            } else {
                if(positionValue > 2) {
                    positionValue--;
                } else {
                    positionValue++;
                }
                list.set(position,positionValue);
                position = nextPosition;
                
            }
        } 
        
        
    }

    public static ArrayList<Integer> getList(String fileName){
        ArrayList<Integer> list = new ArrayList();  
        try (FileReader file = new FileReader(fileName);
                BufferedReader buff = new BufferedReader(file)) {
            boolean eof = false;
            while(!eof){
                String line = buff.readLine();
                if(line == null){
                    eof = true; 
                } else {
                    list.add(Integer.parseInt(line));
                }
            }
            return list;
   
        } catch (IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
            return null;
        } 
    }
    
    
    
}