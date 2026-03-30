package boj.ex13;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1181pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            } else {
                return w1.length() - w2.length();
            }
        });

        String prev = "";
        for (String word : words) {
            if (!prev.equals(word)) {
                sb.append(word).append("\n");
            }
            prev = word;
        }

/*        sb.append(words[0]).append('\n');
        for (int i = 1; i < words.length; i++) {
            // 중복되지 않는 단어만 출력
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append('\n');
            }
        }*/
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}