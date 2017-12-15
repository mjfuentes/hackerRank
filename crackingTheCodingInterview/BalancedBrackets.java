import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (Character c : expression.toCharArray()){
            if (c == ')'){
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != '{') return false;
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) return true;
        
        return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}