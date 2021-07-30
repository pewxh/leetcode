
//        IMPORTS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  problem #118 -> https://leetcode.com/problems/pascals-triangle/

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> pascal = new ArrayList<List<Integer>>();
    pascal.add(new ArrayList<>());
    pascal.get(0).add(1);
    for (int i = 1; i < numRows; i++) {
      List<Integer> temp = new ArrayList<Integer>(i + 1);
      temp.add(1);
      for (int j = 1; j < i; j++) {
        temp.add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
      }
      temp.add(1);
      pascal.add(temp);
    }
    return pascal;
  }
}

// MAIN
public class PascalsTriangle {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int numRows = sc.nextInt();
    sc.close();
    System.out.println(sol.generate(numRows));
  }
}
