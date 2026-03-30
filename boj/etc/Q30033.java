package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;

        int[] plan = new int[n];
        for (int i = 0; i < n; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int page = Integer.parseInt(st.nextToken());
            if (page >= plan[i]) {
                total++;
            }
        }
        System.out.println(total);
    }
}
