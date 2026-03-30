package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalScore = 0;
        int[] science = new int[4];
        for (int i = 0; i < 4; i++) {
            science[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(science);
        totalScore += science[3] + science[2] + science[1] + Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        System.out.println(totalScore);
    }
}
