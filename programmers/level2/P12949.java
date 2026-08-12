package level2;

import java.util.Arrays;

public class P12949 {
	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		System.out.println(Arrays.deepToString(solution(arr1, arr2)));
		System.out.println(Arrays.stream(solution(arr1, arr2)));
	}
	
	// 앞 행렬의 열 개수와 뒤 행렬의 행 개수가 같으면 계산 가능
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int r1 = arr1.length;
		int c1 = arr1[0].length;
		int r2 = arr2.length;
		int c2 = arr2[0].length;
		
		int[][] answer = new int[r1][c2];
		
		for(int i = 0; i < r1; i++) {
			for(int j = 0; j < c2; j++) {
				for(int k = 0; k < c1; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
 			}
		}
		return answer;
    }
}
