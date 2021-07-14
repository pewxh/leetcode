//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// problem #13 -> https://leetcode.com/problems/roman-to-integer/

class Solution {
  public int romanToInt(String s) {
    int n = s.length();
    Map<Character,Integer> mp = new HashMap<>();
    mp.put('I',1);
    mp.put('V',5);
    mp.put('X',10);
    mp.put('L',50);
    mp.put('C',100);
    mp.put('D',500);
    mp.put('M',1000);
    int res = mp.get(s.charAt(n-1));
    for(int i = n-2 ; i >= 0 ; i--){
        int curr = mp.get(s.charAt(i));
        int right = mp.get(s.charAt(i+1));
        if(right > curr)
          res -= curr;
        else 
          res += curr;
    }
    return res;
  }
}

//        MAIN
public class RomanToInt {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);   
    String s = sc.next();
    sc.close();
    int integerRepresentation = sol.romanToInt(s);
    System.out.println(integerRepresentation);
  }
}
