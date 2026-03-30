package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double average = 0;
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        for (double score : scores) {
            sum += (score / max) * 100;
        }

        average = sum / scores.length;
        System.out.println(average);
    }
}