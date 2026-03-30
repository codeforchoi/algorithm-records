package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int time = Integer.parseInt(br.readLine()) % 25;
            sb.append(time < 17 ? "ONLINE" : "OFFLINE").append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
