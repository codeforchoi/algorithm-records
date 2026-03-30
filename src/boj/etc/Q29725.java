package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                char ch = str.charAt(j);
                switch(ch) {
                    case 'P': score += 1; break;
                    case 'p': score -= 1; break;
                    case 'N': case 'B': score += 3; break;
                    case 'n': case 'b': score -= 3; break;
                    case 'R': score += 5; break;
                    case 'r': score -= 5; break;
                    case 'Q': score += 9; break;
                    case 'q': score -= 9; break;
                    default:
                }
            }
        }
        System.out.println(score);
    }
}