package level1;

import java.util.Arrays;

public class P12931 {
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        String[] arr = String.valueOf(n).split("");
        return Arrays.stream(arr).mapToInt(Integer::parseInt).sum();
    }
}
