package programmers.level0;

import java.util.Arrays;

public class P181929 {
    public static void main(String[] args) {
        int[] list = {3, 4, 5, 2, 1};
        System.out.println(solution(list));
    }

    public static int solution(int[] num_list) {
        return Arrays.stream(num_list).reduce(1, (a, b) -> a * b) < Math.pow(Arrays.stream(num_list).sum(), 2) ? 1 : 0;
    }
}
