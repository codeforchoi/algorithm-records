package etc3;

import java.io.*;

//
public class Q11444 {
    private static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long[][] A = {{1, 1}, {1, 0}};
        long[][] result = pow(A, n);

        System.out.println(result[0][1]);
    }

    private static long[][] pow(long[][] A, long exp) {
        if (exp == 1) return A;

        long[][] res = pow(A, exp / 2);
        res = multiply(res, res);

        if (exp % 2 == 1) {
            res = multiply(res, A);
        }

        return res;
    }

    private static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + m1[i][k] * m2[k][j]) % MOD;
                }
            }
        }
        return res;
    }

}
