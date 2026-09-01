package etc;

import java.util.*;
import java.util.stream.*;

/**
 * 조합
 * n개 중에서 순서를 고려하지 않고 k개를 선택하는 경우의 수
 * 아이디어 (파스칼 삼각형)
 * A B C D E 에서 3개를 뽑는 경우의 수라 하면 5C3인데 E를 뽑는 경우 + E를 안뽑는 경우로 나눈다.
 * E를 뽑는 경우는 4C2
 * E를 안뽑는 경우는 4C3
 * 5C3 = 4C2 + 4C3
 */
public class combination {
	public static void main(String[] args) {
		int n = 5;
		int[] arr = { 1, 2, 3, 4, 5};
		boolean[] visited = new boolean[n];		

		for (int i = 1; i <= n; i++) {
			System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
			comb(arr, visited, 0, n, i);
		}

		for (int i = 1; i <= n; i++) {
			System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
			combination1(arr, visited, 0, n, i);
		}
		
		System.out.println(combination2(5, 3));
		
		int[][] map = {{1, 2, 3}, {4, 5, 6}};
		boolean[][] visited2 = new boolean[N][M];
		
		
		combination3(map, visited2, 0, 0, 2);
	}
	
	private static int N = 2;
	private static int M = 3;

	// 재귀 사용
	public static void comb(int[] arr, boolean[] visited, int depth, int n, int k) {
		if (k == 0) {
			print(arr, visited, n);
			return;
		}

		if (depth == n)
			return;

		visited[depth] = true;
		comb(arr, visited, depth + 1, n, k - 1);
		visited[depth] = false;
		comb(arr, visited, depth + 1, n, k);
	}

	// 백트래킹 사용
	public static void combination1(int[] arr, boolean[] visited, int start, int n, int k) {
		if(k == 0) {
			print(arr, visited, n);
			return;
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination1(arr, visited, i + 1, n, k - 1);
			visited[i] = false;
		}
	}
	
	// 조합 성질 이용 재귀 (파스칼 삼각형)
	public static int combination2(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }

        return combination2(n - 1, k - 1) + combination2(n - 1, k);
    }
	
	// 2차원 배열에서의 조합 -> 1차원으로 변경해서 한다.
	public static void combination3(int[][] map, boolean[][] visited, int start, int depth, int k) {
	    if (depth == k) {
	    	print2(map, visited);
	        return;
	    }

	    for (int i = start; i < N * M; i++) {

	        int r = i / M;
	        int c = i % M;

	        visited[r][c] = true;
	        combination3(map, visited, i + 1, depth + 1, k);
	        visited[r][c] = false;
	    }
	}

	public static void print(int[] arr, boolean[] visited, int n) {
		IntStream.range(0, n).filter(i -> visited[i]).forEach(i -> System.out.print(arr[i] + " "));
		System.out.println();
	}
	
	public static void print2(int[][] map, boolean[][] visited) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (visited[i][j]) {
                    System.out.print(map[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

}
