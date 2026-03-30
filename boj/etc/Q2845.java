package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int standard = l * p;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(target - standard).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
