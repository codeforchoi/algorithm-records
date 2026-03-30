package ex8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int upPointNum = 2;
        int addPoint = 1;

        for (int i = 0; i < n; i++) {
            upPointNum += addPoint;
            addPoint *= 2;
        }
        System.out.println(upPointNum * upPointNum);
    }
}
