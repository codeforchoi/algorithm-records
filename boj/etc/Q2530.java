package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        sec += time;
        min += sec / 60;
        sec %= 60;
        hour += min / 60;
        min %= 60;
        hour %= 24;

        sb.append(hour).append(" ").append(min).append(" ").append(sec);
        System.out.println(sb);
    }
}
