package ex22;

import java.io.*;
import java.util.*;

public class Q10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long count = 0;
        long[] sum = new long[N + 1];
        long[] remain = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 처음부터 이 구간까지 나머지가 0이므로 세어준다.
            if(sum[i] == 0) count++;
            // 나머지가 같은 지점을 기록한다.
            // 이 지점 중 2개를 고르면 nC2 = n * (n-1) / 2 하면
            // i, j 지점이라하면 i+1부터 j지점까지는 M으로 나누어 떨어지게 된다.
            remain[(int)sum[i]]++;
        }

        for (int i = 0; i < M; i++) {
            // 나머지가 0인 지점도 처음부터가 아닌 구간을 정하면 M으로 나누어 떨어지므로 계산한다.
            if (remain[i] > 0) {
                count += remain[i] * (remain[i] - 1) / 2; // nC2 = n * (n-1) / 2
            }
        }
        System.out.println(count);
    }
}
