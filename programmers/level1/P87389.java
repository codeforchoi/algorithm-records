package level1;

import java.util.stream.IntStream;

public class P87389 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        return IntStream.range(2, n)
                .filter(x -> n % x == 1)
                .findFirst().orElse(0);
    }
}
