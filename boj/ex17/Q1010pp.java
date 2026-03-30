package ex17;
//포스팅
// 메모리 초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1010pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());
            sb.append(combination(m, n)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    public static BigInteger combination(BigInteger a, BigInteger b) {
        return factorial(a).divide(factorial(a.subtract(b)).multiply(factorial(b)));
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger one = new BigInteger("1");
        if (n.compareTo(one) == 0) {
            return one;
        }
        return n.multiply(factorial(n.subtract(one)));
    }
}