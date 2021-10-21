
//        IMPORTS
import java.util.Scanner;

//  problem #4 -> https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    if (n > m)
      return findMedianSortedArrays(nums2, nums1);
    // first array should always be smaller than or equal to the second array
    int lo = 0;
    int hi = n;
    int size = (n + m + 1) / 2; // number of elements in the first half of partition
    while (lo <= hi) {
      int firstCut = (lo + hi) / 2;
      int secondCut = size - firstCut;
      int l1 = (firstCut > 0) ? nums1[firstCut - 1] : Integer.MIN_VALUE;
      int l2 = (secondCut > 0) ? nums2[secondCut - 1] : Integer.MIN_VALUE;
      int r1 = (firstCut < n) ? nums1[firstCut] : Integer.MAX_VALUE;
      int r2 = (secondCut < m) ? nums2[secondCut] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) {
        if ((n + m) % 2 != 0)
          return Math.max(l1, l2);
        else {
          return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
      } else if (l1 > r2) {
        hi = firstCut - 1;
      } else {
        lo = firstCut + 1;
      }

    }
    return 0.0;
  }
}

// MAIN
public class MedianofTwoSortedArrays {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int nums1[] = new int[n];
    int nums2[] = new int[m];
    for (int i = 0; i < n; i++)
      nums1[i] = sc.nextInt();
    for (int i = 0; i < m; i++)
      nums2[i] = sc.nextInt();
    sc.close();
    System.out.println(sol.findMedianSortedArrays(nums1, nums2));
  }
}
