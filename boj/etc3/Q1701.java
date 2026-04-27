package etc3;

import java.io.*;

//
public class Q1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int maxLen = 0;

        // 문자열의 각 시작점마다 실패 함수를 구함
        for (int i = 0; i < n; i++) {
            String sub = str.substring(i);
            maxLen = Math.max(maxLen, getMaxPi(sub));
        }

        System.out.println(maxLen);
    }

    // KMP 알고리즘의 실패 함수 (Partial Match Table)
    private static int getMaxPi(String p) {
        int m = p.length();
        int[] pi = new int[m];
        int j = 0;
        int max = 0;

        for (int i = 1; i < m; i++) {
            // 일치하지 않으면 이전 일치 지점으로 되돌림
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            // 문자가 일치하면 길이를 늘림
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
        return max;
    }
}
