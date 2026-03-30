package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] year = new int[2];
        int[] month = new int[2];
        int[] day = new int[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            year[i] = Integer.parseInt(st.nextToken());
            month[i] = Integer.parseInt(st.nextToken());
            day[i] = Integer.parseInt(st.nextToken());
        }
        int age = year[1] - year[0];
        if (year[0] == year[1]) {
            sb.append(age);
        } else {
            if (month[0] < month[1]) {
                sb.append(age);
            } else if (month[0] == month[1]) {
                if (day[0] <= day[1]) {
                    sb.append(age);
                } else {
                    sb.append(age - 1);
                }
            } else {
                sb.append(age - 1);
            }
        }
        sb.append("\n");
        sb.append(age + 1).append("\n");
        sb.append(age).append("\n");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
