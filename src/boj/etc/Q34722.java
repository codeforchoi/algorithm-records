package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q34722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean s = Integer.parseInt(st.nextToken()) >= 1000;
            boolean c = Integer.parseInt(st.nextToken()) >= 1600;
            boolean a = Integer.parseInt(st.nextToken()) >= 1500;
            int icpc = Integer.parseInt(st.nextToken());
            boolean r = icpc <= 30 && icpc != -1;
            if (s || c || a || r) {
                num++;
            }
        }
        System.out.println(num);
    }
}
