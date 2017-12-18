import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long makeChange(int[] coins, int money) {
        long[] amount = new long[money + 1];
        amount[0] = 1;
        
        if (money == 0) return 1;
        
        for (int coin : coins){
            for (int i=0; i<amount.length-coin; i++){
                amount[i+coin] += amount[i];
            }        
        }
        
        return amount[money];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}