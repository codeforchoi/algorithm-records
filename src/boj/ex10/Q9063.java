package boj.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        int minX = 10001, maxX = -10001, minY = 10001, maxY = -10001;
        int area = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());

            if (x[i] < minX) minX = x[i];
            if (x[i] > maxX) maxX = x[i];
            if (y[i] < minY) minY = y[i];
            if (y[i] > maxY) maxY = y[i];
        }
        area = (maxX - minX) * (maxY - minY);
        System.out.println(area);
    }
}