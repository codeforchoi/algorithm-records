package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String jinho = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while (n-- > 0) {
            String mbti = br.readLine();
            if (jinho.equals(mbti)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
