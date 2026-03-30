package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int min = Math.min(s, Math.min(k, h));
        if (s + k + h < 100) {
            if (min == s) {
                sb.append("Soongsil");
            } else if (min == k) {
                sb.append("Korea");
            } else {
                sb.append("Hanyang");
            }
        } else {
            sb.append("OK");
        }
        System.out.println(sb);
    }
}
