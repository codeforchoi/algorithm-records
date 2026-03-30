package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        int a = (sum + diff) / 2;
        int b = sum - a;
        if ((sum + diff) % 2 != 0 || sum < diff) {
            sb.append(-1);
        } else {
            sb.append(Math.max(a, b)).append(" ").append(Math.min(a, b));
        }
        System.out.println(sb);
    }
}
