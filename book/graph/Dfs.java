package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 깊이 우선 탐색 순회 출력
 * 입력: graph : [[1, 2], [1, 3], [2, 4], [2, 5], [3, 6], [5, 6]], start : 1, n : 6
 * 출력: [1, 2, 4, 5, 6, 3]
 */
public class Dfs {
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
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
        System.out.println(Arrays.toString(solution(arr, 1, 6)));
    }
}
