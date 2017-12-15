package crackingTheCodingInterview;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.HashMap;
import java.util.regex.*;
public class Solution {
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(minDeletes(a, b));
        
    }
    
    static int minDeletes(String A, String B){
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for (Character a : A.toCharArray()){
            if (map.containsKey(a)){
                map.put(a,map.get(a) + 1);
            } else {
                map.put(a,1);
            }
        }
        
        for (Character b : B.toCharArray()){
            if (map.containsKey(b)){
                map.put(b, map.get(b) - 1);
            } else {
                map.put(b,-1);
            }
        }
        
        int total = 0;
        for (Character c : map.keySet()){
            total += Math.abs(map.get(c));
        }
        
        return total;
    }
}