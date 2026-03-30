package level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P181888sol1 {
    public static void main(String[] args) {
        int[] list = {4, 2, 6, 1, 7, 6};
        System.out.println(Arrays.toString(solution(list, 2)));
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.iterate(0, i -> i < num_list.length, i -> i + n).map(i -> num_list[i]).toArray();
    }
}
