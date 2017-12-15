import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        if (isCreatable(magazine, ransom)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
    static boolean isCreatable(String[] magazine, String[] ransom){
        if (ransom.length > magazine.length) return false;
        int matchedWords = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : ransom){
            if (map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        for (String word : magazine){
            if (map.containsKey(word)){
                Integer count = map.get(word);
                if (count > 0){
                    matchedWords++;
                    map.put(word, count - 1);
                    if (matchedWords == ransom.length){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}