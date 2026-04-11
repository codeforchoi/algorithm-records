package level1;

import java.util.Arrays;

public class P12906sol2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int []arr) {
        int[] temp = new int[arr.length];
        int index = 0;
        for (int n : arr) {
            if (index == 0 || temp[index - 1] != n) {
                temp[index++] = n;
            }
        }
        int[] result = new int[index];
        return Arrays.copyOfRange(temp, 0, index);
    }
}
