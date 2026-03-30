package ex11;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24267pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(n * (n - 1) * (n - 2) / 6).append("\n").append(3);
        System.out.println(sb);
    }
}