package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        arr[0] = 100 - Integer.parseInt(st.nextToken());
        arr[1] = 100 - Integer.parseInt(st.nextToken());
        arr[2] = 100 - (arr[0] + arr[1]);
        arr[3] =  arr[0] * arr[1];
        arr[4] = arr[3] / 100;
        arr[5] = arr[3] % 100;
        for (int i = 0; i < 6; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        sb.append(arr[2] + arr[4]).append(" ").append(arr[5]);
        System.out.println(sb);
    }
}
