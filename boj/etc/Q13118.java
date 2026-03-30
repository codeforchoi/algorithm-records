package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[4];
        for (int i = 0; i < 4; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (p[i] == x) {
                index = i + 1;
                break;
            }
        }
        System.out.println(Math.max(index, 0));
    }
}
