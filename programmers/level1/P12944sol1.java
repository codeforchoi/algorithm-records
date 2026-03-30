package level1;

import java.util.Arrays;

public class P12944sol1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 5};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
