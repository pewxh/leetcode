//        IMPORTS
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

// problem #567 -> https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> m_s1,m_s2;
        m_s1 = new HashMap<>();
        m_s2 = new HashMap<>();
        int n = s1.length() , m = s2.length();
        if(n > m)   return false;
        for(char c:s1.toCharArray()){
            int prev = 0;
            if(m_s1.containsKey(c))
                prev = m_s1.get(c);
            m_s1.put(c,prev+1);
        }
        for(int i=0;i<m;i++){
            int prev = 0;
            char c = s2.charAt(i);
            if(m_s2.containsKey(c))
                prev = m_s2.get(c);
            m_s2.put(c,prev+1);
            if(i >= n){
            c = s2.charAt(i-n);
            prev = m_s2.get(c);
            if(prev > 1)
                m_s2.put(c,prev - 1);
            else
                m_s2.remove(c);
            }
            if(m_s2.equals(m_s1))   return true;
        }
        return false;
    }
}

//        MAIN
public class PermutationinString {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    String s1,s2;
    s1 = sc.next();
    s2 = sc.next();
    sc.close();
    System.out.println(sol.checkInclusion(s1, s2));
  } 
}
