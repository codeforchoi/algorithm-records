package level1;

import java.util.Arrays;

public class P12935sol1 {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {10};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
