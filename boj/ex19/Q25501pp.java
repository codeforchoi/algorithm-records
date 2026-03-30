package ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25501pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int[] result = new int[2];
            result[1] = 1;
            result = isPalindrome(br.readLine(), result);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int[] isPalindrome(String str, int[] result) {
        return recursion(str, 0, str.length() - 1, result);
    }

    public static int[] recursion(String str, int l, int r, int[] result) {
        if (l >= r) {
            result[0] = 1;
            return result;
        } else if (str.charAt(l) != str.charAt(r)) {
            result[0] = 0;
            return result;
        } else {
            result[1]++;
            return recursion(str, l + 1, r - 1, result);
        }
    }
}