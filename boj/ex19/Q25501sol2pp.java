package boj.ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25501sol2pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int[] count = new int[1];
            sb.append(isPalindrome(br.readLine(), count)).append(" ").append(count[0]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int isPalindrome(String str, int[] count) {
        return recursion(str, 0, str.length() - 1, count);
    }

    public static int recursion(String str, int l, int r, int[] count) {
        count[0]++;
        if (l >= r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l + 1, r - 1, count);
    }
}