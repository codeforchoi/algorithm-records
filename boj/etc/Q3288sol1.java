package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3288sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            sb.append(str.charAt(i) == 'I' ? "i" : "L");
        }
        System.out.println(sb);
    }
}
