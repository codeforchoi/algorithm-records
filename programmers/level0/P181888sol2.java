package level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P181888sol2 {
    public static void main(String[] args) {
        int[] list = {4, 2, 6, 1, 7, 6};
        System.out.println(Arrays.toString(solution(list, 2)));
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.range(0, num_list.length)
                .filter(i -> i % n == 0)
                .map(i -> num_list[i])
                .toArray();
    }
}
