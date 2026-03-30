package ex4;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10813pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int basket1 = Integer.parseInt(st.nextToken()) - 1;
            int basket2 = Integer.parseInt(st.nextToken()) - 1;
            int temp = list[basket1];
            list[basket1] = list[basket2];
            list[basket2] = temp;
        }

        for (int i = 0; i < N; i++) {
            sb.append(list[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}