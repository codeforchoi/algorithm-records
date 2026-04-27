package etc3;

import java.io.*;

//
public class Q1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        kmp(t, p);
    }

    private static void kmp(String t, String p) {
        int[] pi = getPi(p);
        int n = t.length();
        int m = p.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            if (t.charAt(i) == p.charAt(j)) {
                if (j == m - 1) {
                    count++;
                    sb.append((i - m + 2)).append(" ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static int[] getPi(String p) {
        int m = p.length();
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
