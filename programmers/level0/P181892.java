package level0;

import java.util.Arrays;

public class P181892 {
    public static void main(String[] args) {
        //int[] list = {2, 1, 6};
        int[] list = {5, 2, 1, 7, 5};
        System.out.println(Arrays.toString(solution(list, 3)));
    }

    public static int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
