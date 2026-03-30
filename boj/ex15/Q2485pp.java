package ex15;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2485pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 1; i < n; i++) {
            gcd = gcd(tree[i] - tree[i - 1], gcd);
        }
        System.out.println((tree[n - 1] - tree[0]) / gcd + 1 - tree.length);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}