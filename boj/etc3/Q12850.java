package etc3;

import java.io.*;

//
public class Q12850 {
    private static final long MOD = 1000000007;
    private static final int N = 8;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());

        long[][] graph = new long[N][N];
        graph[0][1] = graph[0][2] = 1;
        graph[1][0] = graph[1][2] = graph[1][3] = 1;
        graph[2][0] = graph[2][1] = graph[2][3] = graph[2][4] = 1;
        graph[3][1] = graph[3][2] = graph[3][4] = graph[3][5] = 1;
        graph[4][2] = graph[4][3] = graph[4][5] = graph[4][7] = 1;
        graph[5][3] = graph[5][4] = graph[5][6] = 1;
        graph[6][5] = graph[6][7] = 1;
        graph[7][4] = graph[7][6] = 1;

        long[][] result = power(graph, D);
        System.out.println(result[0][0]);
    }

    private static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) return matrix;

        long[][] half = power(matrix, exp / 2);
        long[][] result = multiply(half, half);

        if (exp % 2 == 1) {
            result = multiply(result, matrix);
        }
        return result;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
