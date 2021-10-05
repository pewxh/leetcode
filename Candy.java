
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #135 -> https://leetcode.com/problems/candy/

class Solution {
  public int candy(int[] ratings) {
    int ans = 0;
    int n = ratings.length;
    int left2right[] = new int[n];
    int right2left[] = new int[n];
    Arrays.fill(left2right, 1);
    Arrays.fill(right2left, 1);
    for (int i = 1; i < n; i++)
      if (ratings[i] > ratings[i - 1])
        left2right[i] = left2right[i - 1] + 1;
    for (int i = n - 2; i >= 0; i--)
      if (ratings[i] > ratings[i + 1])
        right2left[i] = right2left[i + 1] + 1;
    for (int i = 0; i < n; i++)
      ans += Math.max(left2right[i], right2left[i]);
    return ans;
  }
}

// MAIN
public class Candy {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ratings[] = new int[n];
    for (int i = 0; i < n; i++)
      ratings[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.candy(ratings));
  }
}
