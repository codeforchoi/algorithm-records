package boj.ex9;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= num; j++) {
                if (j == num) {
                    totalCount++;
                }
                if (num % j == 0) {
                    break;
                }
            }
        }
        System.out.println(totalCount);
    }
}