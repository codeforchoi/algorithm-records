package ex13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        //카운팅 정렬 사용
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            if (arr[i] > 0) {
                sb.append((i + "\n").repeat(arr[i]));
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}