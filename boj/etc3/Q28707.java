package etc3;

import java.io.*;
import java.util.*;

//
public class Q28707 {
    private static int N, M;
    private static SwapOp[] ops;

    private static class Node implements Comparable<Node> {
        int[] arr;
        int cost;

        Node(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static class SwapOp {
        int l, r, c;

        SwapOp(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] start = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        ops = new SwapOp[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            ops[i] = new SwapOp(l, r, c);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<String, Integer> dist = new HashMap<>();

        String startKey = toKey(start);
        dist.put(startKey, 0);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            String curKey = toKey(cur.arr);

            if (dist.get(curKey) < cur.cost) continue;

            if (isSorted(cur.arr)) {
                System.out.println(cur.cost);
                return;
            }

            for (SwapOp op : ops) {
                int[] next = cur.arr.clone();

                int temp = next[op.l];
                next[op.l] = next[op.r];
                next[op.r] = temp;

                int nextCost = cur.cost + op.c;
                String nextKey = toKey(next);

                if (!dist.containsKey(nextKey) || dist.get(nextKey) > nextCost) {
                    dist.put(nextKey, nextCost);
                    pq.offer(new Node(next, nextCost));
                }
            }
        }
        System.out.println(-1);
    }

    private static String toKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(",");
        return sb.toString();
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
