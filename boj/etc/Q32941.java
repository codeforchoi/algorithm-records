package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                if (Integer.parseInt(st.nextToken()) == x) {
                    flag[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (flag[i] == false) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
