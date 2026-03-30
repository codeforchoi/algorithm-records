package ex6;
// 포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ca = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String inputStr = br.readLine();
        int len = inputStr.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = inputStr.charAt(i);

            if (ch == 'c' && i < len - 1) {
                if (inputStr.charAt(i + 1) == '=' || inputStr.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (ch == 'd' && i < len - 1) {
                if (inputStr.charAt(i + 1) == 'z' && i < len - 2) {
                    if (inputStr.charAt(i + 2) == '=') {
                        i += 2;
                    }
                } else if (inputStr.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (ch == 'l' && i < len - 1) {
                if (inputStr.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (ch == 'n' && i < len - 1) {
                if (inputStr.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (ch == 's' && i < len - 1) {
                if (inputStr.charAt(i + 1) == '=') {
                    i++;
                }
            } else if (ch == 'z' && i < len - 1) {
                if (inputStr.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;
        }
        System.out.println(count);
    }
}