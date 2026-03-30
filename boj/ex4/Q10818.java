package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 문제에서 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수라 정의
        int max = -1000001;
        int min = 1000001;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        System.out.println(min + " " + max);
    }
}