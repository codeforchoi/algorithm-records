package ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (k == 1) {
                    result = i;
                    break;
                }
                k--;
            }
        }
        System.out.println(result);
    }
}