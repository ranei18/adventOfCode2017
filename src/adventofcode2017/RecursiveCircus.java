package adventOfCode2017;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursiveCircus {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = "(\\w+)\\s\\p{Punct}(\\d+)\\p{Punct}\\s\\p{Punct}+\\s(.+)";
        ArrayList<String> key = new ArrayList();
        ArrayList<String> value = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        
        while(scan.hasNext()) {
            String line = scan.nextLine();
            Matcher m = p.matcher(line);
            if (m.find()) {
                key.add(m.group(1));
                StringTokenizer split = new StringTokenizer(m.group(3),", ");
                while (split.hasMoreTokens()) {
                    value.add((String)split.nextToken());
                }
            }
        }
        for (String id : key) {
            if (!value.contains(id)) {
                System.out.println(id);
                break;
            }
        }
    }
}
