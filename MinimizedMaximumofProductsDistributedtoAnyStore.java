
//        IMPORTS
import java.util.Scanner;

//  problem #2064 -> https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

class Solution {
  public int minimizedMaximum(int n, int[] quantities) {
    int lo = 0;
    int hi = Integer.MAX_VALUE;
    int ans = hi;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      int count = 0;
      for (int it : quantities) {
        count += Math.ceil((float) it / mid);
      }
      if (count <= n) {
        ans = mid;
        hi = mid - 1;
      } else
        lo = mid + 1;
    }
    return ans;
  }
}

// MAIN
public class MinimizedMaximumofProductsDistributedtoAnyStore {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int quantities[] = new int[size];
    for (int i = 0; i < size; i++)
      quantities[i] = sc.nextInt();
    int n = sc.nextInt();
    sc.close();
    System.out.println(sol.minimizedMaximum(n, quantities));
  }
}
