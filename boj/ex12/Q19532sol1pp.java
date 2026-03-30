package ex12;
//포스팅
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19532sol1pp {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());
        int f = Integer.parseInt(token.nextToken());

        // 연립방정식 풀듯이 x로 계산하고, y로 계산하고 해서 나온 식
        int x = (c * e - b * f) / (a * e - b * d);
        int y = (c * d - a * f) / (b * d - a * e);

        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}