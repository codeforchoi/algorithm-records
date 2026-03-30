package boj.ex18;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        //최빈값 계산
        int mode = arr[0];
        int nowNum = arr[0];
        int count = 0;
        int max = 0;
        boolean secondCheck = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == nowNum) {
                count++;
            } else {
                nowNum = arr[i];
                count = 1;
            }

            if (count > max) {
                max = count;
                mode = nowNum;
                secondCheck = true;
            } else if (count == max && secondCheck == true) {
                mode = nowNum;
                secondCheck = false;
            }
        }
        sb.append(Math.round(sum / n)).append("\n");
        sb.append(arr[(n - 1) / 2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(arr[n - 1] - arr[0]);
        System.out.println(sb);
    }
}