package ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n").append("1");
        System.out.println(sb);
    }
}