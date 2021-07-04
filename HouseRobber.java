//				IMPORTS
import java.util.Scanner;

// problem #198 -> https://leetcode.com/problems/house-robber/

class Solution {
	public int rob(int[] nums){
		int mx = Math.max(nums[0],nums[1]);
		int sm = nums[0];
		if(nums.length < 2)
			return sm;
		for(int i = 2;i < nums.length;i++){
			int curr = Math.max(sm + nums[i],mx);
			sm = mx;
			mx = curr;
		}
		return mx;
	}
}

//				MAIN
public class HouseRobber {
	public static void main(String[] args) {
		int n; // number of houses
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = sc.nextInt();
		Solution sol = new Solution();
		int res = sol.rob(nums);
		System.out.print(res);
	}
}
