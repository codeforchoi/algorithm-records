package level1;

import java.util.Arrays;

public class P12950 {
    public static void main(String[] args) {
        int[][] arr1_1 = {{1, 2}, {2, 3}};
        int[][] arr1_2 = {{3, 4}, {5, 6}};
        int[][] arr2_1 = {{1}, {2}};
        int[][] arr2_2 = {{3}, {4}};
        System.out.println(Arrays.deepToString(solution(arr1_1, arr1_2)));
        System.out.println(Arrays.deepToString(solution(arr2_1, arr2_2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }
}
