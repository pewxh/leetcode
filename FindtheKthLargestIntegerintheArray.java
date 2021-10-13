
//        IMPORTS
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//  problem #1985 -> https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

class Solution {
  public String kthLargestNumber(String[] nums, int k) {
    PriorityQueue<String> maxheap;
    maxheap = new PriorityQueue<>(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() != s2.length())
          return Integer.compare(s1.length(), s2.length());
        return s1.compareTo(s2);
      }
    });
    for (var num : nums) {
      maxheap.add(num);
      if (maxheap.size() > k)
        maxheap.poll();
    }
    return maxheap.poll();
  }
}

// MAIN
public class FindtheKthLargestIntegerintheArray {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String nums[] = new String[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    System.out.println(sol.kthLargestNumber(nums, k));
  }
}
