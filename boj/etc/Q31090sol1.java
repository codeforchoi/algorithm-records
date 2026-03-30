package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31090sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int year = Integer.parseInt(br.readLine());
            int div = year % 100;
            if ((year + 1) % div == 0) {
                sb.append("Good");
            } else {
                sb.append("Bye");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
