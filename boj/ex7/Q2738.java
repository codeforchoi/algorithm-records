package ex7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];
        int[][] result = new int[n][m];

        for (int i = 0; i < 2 * n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (i < n) {
                    matrixA[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    matrixB[i - n][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
                sb.append(result[i][j]);
                if (j != m - 1) {
                    sb.append(" ");
                }
            }
            if (i != n - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
