package etc2;

import java.io.*;
import java.util.*;

public class Q10942 {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1; // 번째 수이므로 인덱스에 맞게 바꾼다.
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(isPalindrome(start, end) ? 1 : 0).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean isPalindrome(int start, int end) {
        int diff = end - start;
        int count = (diff % 2 == 0) ? diff / 2 : (diff + 1) / 2;
        for (int i = 0; i < count; i++) {
            if (numbers[start + i] != numbers[end - i]) {
                return false;
            }
        }
        return true;
    }
}
