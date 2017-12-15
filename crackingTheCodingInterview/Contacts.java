import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")){
                while (contact.length() > 0){
                    if (map.containsKey(contact)){
                        map.put(contact, map.get(contact) + 1);
                    } else {
                        map.put(contact,1);
                    }
                    contact = contact.substring(0, contact.length()-1);
                }
            } else {
                int result = 0;
                if (map.containsKey(contact)){
                    System.out.println(map.get(contact));
                } else {
                    System.out.println(0);
                }
            }
        }
        
    }
}