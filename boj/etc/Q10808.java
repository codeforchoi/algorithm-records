package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        int[] arr = new int[26];
        for (char ch : str) {
            arr[ch - 'a']++;
        }
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
