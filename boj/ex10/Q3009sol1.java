package ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3009sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int a = 0, b = 0;
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        if (x[0] == x[1]) a = x[2];
        else if (x[0] == x[2]) a = x[1];
        else a = x[0];
        sb.append(a).append(" ");

        if (y[0] == y[1]) b = y[2];
        else if (y[0] == y[2]) b = y[1];
        else b = y[0];
        sb.append(b);
        System.out.println(sb);
    }
}