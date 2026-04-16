package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * 너비 우선 탐색 순회 출력
 * 입력: graph : [[1, 2], [1, 3], [2, 4], [2, 5], [3, 6], [3, 7], [4, 8], [5, 8], [6, 9], [7, 9]], start : 1, n : 9
 * 출력: [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
public class Bfs {
    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            answer.add(now);
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        System.out.println(Arrays.toString(solution(arr, 1, 9)));
    }
}
