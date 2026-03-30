package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P181919 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
    }

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            list.add(n);
            n = (n % 2 == 0) ? (n / 2) : (3 * n + 1);
        }
        list.add(1);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
        //return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
