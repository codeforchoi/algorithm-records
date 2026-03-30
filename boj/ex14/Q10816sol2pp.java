package ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10816sol2pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] counting = new int[20000001]; // -10,000,000 ~ 10,000,000 입력범위

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            counting[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}