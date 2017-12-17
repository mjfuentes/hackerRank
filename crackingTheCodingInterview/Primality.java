import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        boolean prime;
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            prime = true;
            if ( n == 1) prime = false;
            for (int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0){
                    prime = false;
                    break;
                } 
            }
            if (prime){
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}