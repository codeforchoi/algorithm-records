package ex18;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2108sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[8001]; // 입력값이 -4000 ~ 4000
        double sum = 0;
        int max = -4001;
        int min = 4001;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 4000]++;
            sum += num;

            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int middleCount = 0;
        int middle = 0;
        int maxCount = 0;
        int mode = 0;
        boolean isSecond = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            // 중앙값
            if (arr[i] > 0) {
                if (middleCount < (n + 1) / 2) {
                    middleCount += arr[i];
                    middle = i - 4000;
                }
            }

            // 최빈값
            if (arr[i] > maxCount) {
                maxCount = arr[i];
                mode = i - 4000;
                isSecond = true;
            } else if (arr[i] == maxCount && isSecond) {
                mode = i - 4000;
                isSecond = false;
            }
        }
        sb.append(Math.round(sum / n)).append("\n");
        sb.append(middle).append("\n");
        sb.append(mode).append("\n");
        sb.append(max - min);
        System.out.println(sb);
    }
}