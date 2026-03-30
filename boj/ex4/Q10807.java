package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == v) {
                count++;
            }
        }
        System.out.println(count);
    }

}