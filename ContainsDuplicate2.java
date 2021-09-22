
//        IMPORTS
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  problem #219 -> https://leetcode.com/problems/contains-duplicate-ii/

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> lastSeen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (lastSeen.containsKey(nums[i])) {
        if (i - lastSeen.get(nums[i]) <= k)
          return true;
      }
      lastSeen.put(nums[i], i);
    }
    return false;
  }
}

// MAIN
public class ContainsDuplicate2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.println(sol.containsNearbyDuplicate(nums, k));
  }
}
