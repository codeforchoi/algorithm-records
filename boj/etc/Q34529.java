package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q34529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken()) / 100 * x + Integer.parseInt(st.nextToken()) / 50 * y + Integer.parseInt(st.nextToken()) / 20 * z;
        System.out.println(total);
    }
}
