package boj.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int totalSum = 0;
        int min = -1;

        for (int i = start; i <= end; i++) {
            if (i == 1) continue;
            boolean flag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                totalSum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (min == -1) {
            sb.append(min);
        } else {
            sb.append(totalSum).append("\n").append(min);
        }
        System.out.println(sb);
    }
}