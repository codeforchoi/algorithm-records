package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String pw = br.readLine();
            sb.append(pw.length() >= 6 && pw.length() <= 9 ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
