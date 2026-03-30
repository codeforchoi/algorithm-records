package ex8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int weight = 1; //

        for (int i = n.length() - 1; i >= 0; i--) {
            char ch = n.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                result += (ch - 'A' + 10) * weight;
            } else {
                result += (ch - '0') * weight;
            }
            weight *= b;
        }
        System.out.println(result);
    }
}