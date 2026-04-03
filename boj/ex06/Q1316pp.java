package ex06;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1316pp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check() throws IOException {
        boolean[] alphabet = new boolean[26]; // 기본적으로 false로 초기화
        String inputStr = br.readLine();
        int prev = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            int now = inputStr.charAt(i);

            if (prev != now) {
                if (!alphabet[now - 'a']) {
                    alphabet[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }
        return true;
    }
}