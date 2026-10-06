package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N^2 log N)
 * 공간 복잡도 : O(N^2)
 * prim with PriorityQueue
 */
// Memory: 82,988 kb, Time: 309 ms, Code Length: 1,694
public class S1251_prim {
  private static class Edge {
    int to;
    long cost;

    public Edge(int to, long cost) {
      super();
      this.to = to;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {

      int N = Integer.parseInt(br.readLine());

      int[] x = new int[N];
      int[] y = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        x[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        y[i] = Integer.parseInt(st.nextToken());
      }

      double E = Double.parseDouble(br.readLine());

      long minCost = 0;
      int count = 0;
      boolean[] visited = new boolean[N];

      PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
      pq.offer(new Edge(0, 0));

      while (!pq.isEmpty() && count < N) {
        Edge cur = pq.poll();

        if (visited[cur.to])
          continue;

        visited[cur.to] = true;
        minCost += cur.cost;
        count++;

        for (int next = 0; next < N; next++) {
          if (visited[next])
            continue;

          long dx = (long) x[cur.to] - x[next];
          long dy = (long) y[cur.to] - y[next];
          long cost = dx * dx + dy * dy;

          pq.offer(new Edge(next, cost));
        }
      }

      sb.append("#").append(tc).append(" ").append(Math.round(minCost * E)).append("\n");
    }
    System.out.println(sb);
  }
}
