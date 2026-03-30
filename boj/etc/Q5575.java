package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int sum1 = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int sum2 = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int total = sum2 - sum1;
            sb.append(total / 3600).append(" ").append(total / 60 % 60).append(" ").append(total % 60).append("\n");
        }
        System.out.println(sb);
    }
}
