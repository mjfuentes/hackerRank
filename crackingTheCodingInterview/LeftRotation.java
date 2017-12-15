import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int[] rotated = new int[n];
        int newPos = 0;
        for (int i = 0; i<a.length; i++){
            newPos = (n + i - k) % n;
            rotated[newPos] = a[i];
        }
        
        for (int num:rotated){
            System.out.print(num + " ");
        }
    }
}