//				IMPORTS
import java.util.Scanner;

// problem #200 -> https://leetcode.com/problems/number-of-islands/

class Solution {
	private int r,c;
	private boolean vis[][];
	private int area(char[][]grid,int i,int j){
		if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == '0' || vis[i][j])
			return 0;
		return 1 + area(grid,i-1,j) + area(grid,i+1,j) + area(grid,i,j-1) + area(grid,i,j+1);
	}
  public int numIslands(char[][] grid) {
      int numIslands = 0;
			r = grid.length;	c = grid[0].length;
			vis = new boolean[r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					if(area(grid,i,j) > 0)
						numIslands++;
			return numIslands;
   }
}

//				MAIN
public class NumberOfIslands{
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char grid[][] = new char[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				grid[i][j] = sc.next().charAt(0);
		int numIslands = sol.numIslands(grid);
		System.out.print(numIslands);
	}
}
