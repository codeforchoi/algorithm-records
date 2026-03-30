package boj.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] sides = new int[3];
            int maxSide = 0;
            int sum = 0;
            for (int i = 0; i < sides.length; i++) {
                sides[i] = Integer.parseInt(st.nextToken());
                sum += sides[i];
                if (sides[i] > maxSide) {
                    maxSide = sides[i];
                }
            }

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            if (sum - maxSide > maxSide) {
                if (sides[0] == sides[1] && sides[1] == sides[2]) {
                    sb.append("Equilateral");
                } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[2] == sides[0]) {
                    sb.append("Isosceles");
                } else if (sides[0] != sides[1] && sides[1] != sides[2] && sides[2] != sides[0]) {
                    sb.append("Scalene");
                }
            } else {
                sb.append("Invalid");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
