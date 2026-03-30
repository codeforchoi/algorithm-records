package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringBuilder line = new StringBuilder(br.readLine());
            if (line.toString().equals("END")) {
                break;
            }
            sb.append(line.reverse()).append("\n");
        }
        System.out.println(sb);
    }
}
