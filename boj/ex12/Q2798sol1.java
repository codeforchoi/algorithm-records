package ex12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798sol1 {

    private static int n, m, answer;
    private static int[] numbers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int num, int depth) {
        if (depth == 3) { // 숫자 3개를 선택했다면
            if (num <= m) {
                answer = Math.max(answer, num);
            }
            return;
        }

        for (int i = index; i < n; i++) {
            dfs(i + 1, num + numbers[i], depth + 1);
        }
    }
}