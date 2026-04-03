package ex08;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1193pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(br.readLine());
        int line = 1; // 대각선 라인
        int num = 1;  // 분자
        int den = 1;  // 분모

        while (x > line) {
            x -= line;
            line++;
        }

        // if ((line & 1) == 0) 이 조건식도 가능
        if (line % 2 == 0) {
            num = x;
            den = line - x + 1;
        } else {
            num = line - x + 1;
            den = x;
        }
        sb.append(num).append("/").append(den);
        System.out.println(sb);
    }
}