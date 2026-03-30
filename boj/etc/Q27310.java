package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q27310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String emoji = br.readLine();
        int count = 0;
        for (int i = 0; i < emoji.length(); i++) {
            if (emoji.charAt(i) == '_') {
                count++;
            }
        }
        int score = emoji.length() + 2 + count * 5;
        System.out.println(score);
    }
}
