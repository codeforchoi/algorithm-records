package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11948sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalScore = 0;
        int min = 101;
        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(br.readLine());
            totalScore += score;
            min = Math.min(min, score);
        }
        totalScore += Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())) - min;
        System.out.println(totalScore);
    }
}