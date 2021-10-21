
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//  problem #503 -> https://leetcode.com/problems/next-greater-element-ii/

class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int nge[] = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
        stack.pop();
      }
      nge[i % n] = (stack.isEmpty()) ? -1 : stack.peek();
      stack.add(nums[i % n]);
    }
    return nge;
  }
}

public class NextGreaterElement2 {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    sc.close();
    System.out.println(Arrays.toString(sol.nextGreaterElements(nums)));
  }
}
