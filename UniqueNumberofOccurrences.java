//        IMPORTS
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// problem #1207 -> https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    Set<Integer> st = new HashSet<>();
    for(int i:arr){
      int prev = 0;
      if(freq.containsKey(i))
        prev = freq.get(i);
      freq.put(i, prev+1);
    }
    st.addAll(freq.values());
    return (st.size() == freq.size());
  }
}

//        MAIN
public class UniqueNumberofOccurrences {
  public static void main(String[] args) {
  Solution sol = new Solution();  
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for(int i=0;i<n;i++)
    arr[i] = sc.nextInt();
  System.out.println(sol.uniqueOccurrences(arr));
  } 
}
