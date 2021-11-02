
//        IMPORTS
import java.util.Arrays;
import java.util.Scanner;

//  problem #684 -> https://leetcode.com/problems/redundant-connection/

class Solution {
  private int parent[];
  private int rank[];

  public int[] findRedundantConnection(int[][] edges) {
    initialize(10005); // initialize a DSU having 10005 nodes
    for (int it[] : edges) {
      int a = it[0], b = it[1];
      if (!union(a, b)) // first edge where union operation is skipped is the answer required
        return it;
    }
    return new int[] { -1, -1 };
  }

  private void initialize(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i; // each node is a parent
      rank[i] = 0; // rank of each node is 0 ( this step is optional in JAVA)
    }
  }

  private int findParent(int a) {
    return parent[a] = (parent[a] == a ? a : findParent(parent[a]));
  }

  private boolean union(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (a == b)
      return false; // both the nodes are already connected, so skip the operation

    if (rank[a] == rank[b]) {
      rank[a]++;
    }
    if (rank[a] > rank[b]) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
    return true;
  }
}

// MAIN
public class RedundantConnection {
  public static void main(String[] args) {
    Solution sol = new Solution();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int edges[][] = new int[n][2];
    for (int i = 0; i < n; i++) {
      edges[i][0] = sc.nextInt();
      edges[i][1] = sc.nextInt();
    }
    sc.close();
    System.out.println(Arrays.toString(sol.findRedundantConnection(edges)));
  }
}
