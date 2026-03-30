package ex16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9012sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            sb.append(isVps(br.readLine())).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static String isVps(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') count++;
            else if (count == 0) return "NO";
            else count--;
        }
        if (count == 0) return "YES";
        else return "NO";
    }
}