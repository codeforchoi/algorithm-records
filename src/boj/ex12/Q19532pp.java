package boj.ex12;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19532pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] cons = new int[6];
        int x, y;

        for (int i = 0; i < 6; i++) {
            cons[i] =Integer.parseInt(st.nextToken());
        }

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                int equation1 = cons[0] * i + cons[1] * j;
                int equation2 = cons[3] * i + cons[4] * j;
                if (equation1 == cons[2] && equation2 == cons[5]) {
                    x = i;
                    y = j;
                    sb.append(x).append(" ").append(y);
                }
            }
        }
        System.out.println(sb);
    }
}