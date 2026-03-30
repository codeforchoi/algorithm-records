package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;

public class P181888 {
    public static void main(String[] args) {
        int[] list = {4, 2, 6, 1, 7, 6};
        System.out.println(Arrays.toString(solution(list, 2)));
    }

    public static int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num_list.length; i += n) {
            list.add(num_list[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
