package boj.ex4;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10810pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int[] info = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int ball = Integer.parseInt(st.nextToken());

            for (int o = start; o <= end; o++) {
                info[o] = ball;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(info[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}