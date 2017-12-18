import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            int[] ways = new int[n+1];
            System.out.println(countWays(n,ways));
        }
    }
    
    public static int countWays(int stairs, int[] ways){
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;
        if (stairs == 3) return 4;
        
        if (ways[stairs] == 0) ways[stairs] = countWays(stairs -1, ways) + countWays(stairs -2, ways) + countWays(stairs -3, ways);
        
        return ways[stairs];
    }
}