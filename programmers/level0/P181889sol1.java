package level0;

import java.util.Arrays;

public class P181889sol1 {
    public static void main(String[] args) {
        int[] list = {2, 1, 6};
        System.out.println(Arrays.toString(solution(list, 1)));
    }

    public static int[] solution(int[] num_list, int n) {
        return Arrays.copyOf(num_list, n);
    }
}
