package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q34552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] m = new int[11];
        for (int i = 0; i < 11; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int b = m[Integer.parseInt(st.nextToken())];
            double l = Double.parseDouble(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (l >= 2.0 && s >= 17) {
                total += b;
            }
        }
        System.out.println(total);
    }
}
