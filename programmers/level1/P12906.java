package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12906 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int temp = arr[0];
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != temp) {
                list.add(arr[i]);
                temp = arr[i];
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
