package boj.ex5;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10809pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alphabet = new int[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (alphabet[ch - 'a'] == -1) {
                alphabet[ch - 'a'] = i;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]);
            if (i != alphabet.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}