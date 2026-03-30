package ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int x = 0, y = 0;
        int[][] point = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        if (point[0][0] == point[1][0]) {
            x = point[2][0];
        } else if (point[0][0] == point[2][0]) {
            x = point[1][0];
        } else if (point[1][0] == point[2][0]) {
            x = point[0][0];
        }
        sb.append(x).append(" ");

        if (point[0][1] == point[1][1]) {
            y = point[2][1];
        } else if (point[0][1] == point[2][1]) {
            y = point[1][1];
        } else if (point[1][1] == point[2][1]) {
            y = point[0][1];
        }
        sb.append(y);
        System.out.println(sb);
    }
}