package programmers.level0;

import java.util.Arrays;

public class P181927 {
    public static void main(String[] args) {
        //int[] list = {2, 1, 6};
        int[] list = {5, 2, 1, 7, 5};
        System.out.println(Arrays.toString(solution(list)));
    }

    public static int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] result = Arrays.copyOf(num_list, n + 1);
        result[n] = num_list[n - 1] > num_list[n - 2] ? num_list[n - 1] - num_list[n - 2] : num_list[n - 1] * 2;
        return result;
    }
}
