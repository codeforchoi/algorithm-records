package programmers.level0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P181944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n % 2 == 0 ? n + " is even" : n + " is odd");
    }
}
