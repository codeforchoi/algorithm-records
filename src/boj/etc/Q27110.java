package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value < n) total += value;
            else total += n;
        }
        System.out.println(total);
    }
}
