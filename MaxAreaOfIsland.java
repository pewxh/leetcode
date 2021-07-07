//				IMPORTS
import java.util.Scanner;

// problem #695 -> https://leetcode.com/problems/max-area-of-island/

class Solution {
	private int r,c;
	private int area(int[][]grid,int i,int j,boolean[][]vis){
		if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0 || vis[i][j])
			return 0;
		vis[i][j] = true;
		return area(grid,i-1,j,vis) + area(grid,i+1,j,vis) + area(grid,i,j-1,vis) + area(grid,i,j+1,vis) + 1;
	}
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = -1;
		r = grid.length;
		c = grid[0].length;
		boolean vis[][] = new boolean[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				maxArea = Math.max(maxArea,area(grid,i,j,vis));
			}
		}
		return maxArea;
    }
}

//				MAIN

class maxAreaOfIsland{
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(); // number of rows
		int c = sc.nextInt(); // number of columns
		int grid[][] = new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				grid[i][j] = sc.nextInt();
		int maxArea = sol.maxAreaOfIsland(grid);
		System.out.println(maxArea);
	}
}