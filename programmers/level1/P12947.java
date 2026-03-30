package level1;

import java.util.Arrays;

public class P12947 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        return x % Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum() == 0;
    }
}
