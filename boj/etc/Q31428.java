package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q31428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target = br.readLine();
        int count = 0;
        while (n-- > 0) {
            if (target.equals(st.nextToken())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
