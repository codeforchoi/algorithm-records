package level0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P181930 {
    public static void main(String[] args) {
        System.out.println(solution(2, 6, 1));
        System.out.println(solution(5, 3, 3));
        System.out.println(solution(4, 4, 4));
    }

    public static int solution(int a, int b, int c) {
        Set<Integer> set = new HashSet<>(Arrays.asList(a, b, c));
        int n = 4 - set.size();
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i);
        }
        return (int) result;
    }
}
