
//        IMPORTS
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//  problem #496 -> https://leetcode.com/problems/next-greater-element-i/

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums2.length;
    int nge[] = new int[n]; // array to store Next Greater Element of each index
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i])
        stack.pop();
      nge[i] = (stack.empty() ? -1 : stack.peek());
      stack.push(nums2[i]);
    }
    Map<Integer, Integer> reverseMapIdx = new HashMap<Integer, Integer>(); // maps element of nums2 to its index
    for (int i = 0; i < n; i++) {
      reverseMapIdx.put(nums2[i], i);
    }

    int ans[] = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      ans[i] = nge[reverseMapIdx.get(nums1[i])];
      // use reverse map to get the index and get answer using nge array
    }
    return ans;
  }
}

// MAIN
public class NextGreaterElement {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int nums1[] = new int[n1];
    int nums2[] = new int[n2];
    for (int i = 0; i < n1; i++)
      nums1[i] = sc.nextInt();
    for (int i = 0; i < n2; i++)
      nums2[i] = sc.nextInt();
    sc.close();
    System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2)));
  }
}
