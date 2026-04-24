package etc;

import java.io.*;
import java.util.*;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            String line = br.readLine();

            int score = 0;
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'O') {
                    count++;
                    score += count;
                } else {
                    count = 0;
                }
            }
            sb.append(score).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
