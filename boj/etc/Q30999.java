package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'O') {
                    count++;
                }
            }
            if (count > (m - count)) {
                totalCount++;
            }
        }
        System.out.println(totalCount);
    }
}
