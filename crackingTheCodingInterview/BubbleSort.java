import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int totalSwaps = 0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            totalSwaps += sortArray(a, a_i);
        }
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);

    }
    
    static int sortArray(int[] items, int end){
        int numberOfSwaps = 0;
        for (int j = end; j > 0; j--) {
            if (items[j] < items[j - 1]) {
                
                int temp = items[j];
                items[j]= items[j-1];
                items[j-1] = temp; 
                
                numberOfSwaps++;
            }
        }
        return numberOfSwaps;
    }
}