
//        IMPORTS
import java.util.LinkedList;
import java.util.Queue;

//  problem #542 -> https://leetcode.com/problems/01-matrix/

class Solution {
  private class Cell {
    int i;
    int j;

    public Cell(int _i, int _j) {
      i = _i;
      j = _j;
    }
  }

  public int[][] updateMatrix(int[][] mat) {
    if (mat.length == 0)
      return mat;
    int n = mat.length;
    int m = mat[0].length;
    Queue<Cell> queue = new LinkedList<>();
    int dist[][] = new int[n][m];
    for (int i = 0; i < n; i++)
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          queue.add(new Cell(i, j));
          dist[i][j] = 0;
        }
      }
    }
    int dx[] = { 0, 0, -1, 1 };
    int dy[] = { 1, -1, 0, 0 };
    while (!queue.isEmpty()) {
      var cur = queue.poll();
      for (int it = 0; it < 4; it++) {
        int next_i = cur.i + dx[it];
        int next_j = cur.j + dy[it];
        int next_dist = dist[cur.i][cur.j] + 1;
        if (inRange(next_i, 0, n) && inRange(next_j, 0, m)) {
          if (dist[next_i][next_j] > next_dist) {
            queue.add(new Cell(next_i, next_j));
            dist[next_i][next_j] = next_dist;
          }
        }
      }
    }
    return dist;
  }

  private boolean inRange(int cur, int start, int end) {
    return start <= cur && cur < end;
  }
}

// MAIN