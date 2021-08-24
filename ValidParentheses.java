
//        IMPORTS
import java.util.Scanner;
import java.util.Stack;

//  problem #20 -> https://leetcode.com/problems/valid-parentheses/

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char ch : s.toCharArray()) {
      if (ch == '[' || ch == '{' || ch == '(')
        stack.push(ch);
      else {
        if (stack.empty())
          return false;
        if (ch == ']' && stack.lastElement() == '[')
          stack.pop();
        else if (ch == '}' && stack.lastElement() == '{')
          stack.pop();
        else if (ch == ')' && stack.lastElement() == '(')
          stack.pop();
        else
          return false;
      }
    }
    return stack.empty();
  }
}

// MAIN
public class ValidParentheses {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(sol.isValid(s));
  }
}
