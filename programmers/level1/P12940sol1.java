package level1;

import java.util.Arrays;

public class P12940sol1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static int[] solution(int n, int m) {
        int g = gcd(n, m);
        return new int[]{g, n * m / g};
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
