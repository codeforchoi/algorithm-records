package boj.ex5;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2908pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int reverseA = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int reverseB = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        System.out.println(reverseA > reverseB ? reverseA : reverseB);
    }
}