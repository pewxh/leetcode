
//        IMPORTS
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// problem #785 -> https://leetcode.com/problems/is-graph-bipartite/

class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int vis[] = new int[n];
    Arrays.setAll(vis, (i) -> -1);
    for (int i = 0; i < n; i++) {
      if (vis[i] == -1) {
        if (!bipartiteHelperBFS(graph, vis, i))
          return false;
      }
    }
    return true;
  }

  private boolean bipartiteHelperBFS(int[][] graph, int[] vis, int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    vis[start] = 1;
    while (q.isEmpty() != true) {
      int curr = q.poll();
      for (int i = 0; i < graph[curr].length; i++) {
        int nb = graph[curr][i];
        if (vis[nb] == -1) {
          q.add(nb);
          vis[nb] = 1 - vis[curr];
        } else if (vis[nb] == vis[curr])
          return false;
      }
    }
    return true;
  }
}

// MAIN
public class IsGraphBipartite {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
    System.out.println(sol.isBipartite(graph));
  }
}
