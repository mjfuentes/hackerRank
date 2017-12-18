import java.util.*;

public class Solution {

    
    public static int fibonacci(int n) {
        int first =0;
        int second =1;
        for (int i=2; i <= n; i++){
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}