package level1;

import java.util.Arrays;
import java.util.stream.LongStream;

public class P12954 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }

    public static long[] solution(int x, int n) {
        return LongStream.iterate(x, i -> i + x).limit(n).toArray();
    }
}
