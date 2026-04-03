package level1;

import java.util.Arrays;

public class P12935 {
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

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int index = 0;
        int[] result = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            } else {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }
}
