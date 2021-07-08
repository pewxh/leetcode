//        IMPORTS
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//  problem #459 -> https://leetcode.com/problems/repeated-substring-pattern/

class Solution {
    private List<Integer> piBuilder(String p){
      List<Integer> pi = new ArrayList<>(Collections.nCopies(p.length(), -1));
      int i = 1 , j = 0;
      while(i < p.length()){
        if(p.charAt(i) == p.charAt(j)){
          pi.set(i,j);
          i++;
          j++;
        }
        else if (j > 0)
          j = pi.get(j-1) + 1;
        else
          i++;
      }
      return pi;
    }
    private boolean kmp(String s,String p){
      List<Integer> pi = piBuilder(p);
      int i = 0 , j = 0;
      while(i + p.length()-j <= s.length()){
        if(p.charAt(j) == s.charAt(i)){
          if(j == p.length()-1)
            return true;
          i++;  j++;
        }
        else if(j > 0)
          j = pi.get(j-1) + 1;
        else
          i++;
      }
      return false;
    }
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        ss = ss.substring(1,ss.length() - 1);
        return kmp(ss,s);
    }
}

//        MAIN
public class RepeatedSubstringPattern {
  public static void main(String[] args) {
  Solution sol = new Solution();
  Scanner sc = new Scanner(System.in);
  String s = sc.next();
  sc.close();
  System.out.print(sol.repeatedSubstringPattern(s));
  }
}
