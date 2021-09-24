
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #350 -> https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    int freq1[] = new int[1001];
    int freq2[] = new int[1001];
    int res[] = new int[nums1.length + nums2.length];
    int it = 0;
    for (int i : nums1)
      freq1[i]++;
    for (int i : nums2)
      freq2[i]++;
    for (int i = 0; i < 1001; i++) {
      for (int j = 0; j < Math.min(freq1[i], freq2[i]); j++)
        res[it++] = i;
    }

    return Arrays.copyOf(res, it);
  }
}

// MAIN
public class IntersectionofTwoArrays2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution sol = new Solution();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int nums1[] = new int[n];
    int nums2[] = new int[m];
    for (int i = 0; i < n; i++)
      nums1[i] = sc.nextInt();
    for (int i = 0; i < m; i++)
      nums2[i] = sc.nextInt();
    sc.close();
    int intersection[] = sol.intersect(nums1, nums2);
    System.out.println(Arrays.toString(intersection));
  }
}
