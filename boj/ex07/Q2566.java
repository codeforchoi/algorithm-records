package ex07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int maxValue = -1;
        int maxRow = 0;
        int maxColumn = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > maxValue) {
                    maxValue = value;
                    maxRow = i + 1;
                    maxColumn = j + 1;
                }
            }
        }
        sb.append(maxValue).append("\n").append(maxRow).append(" ").append(maxColumn);
        System.out.println(sb);
    }
}