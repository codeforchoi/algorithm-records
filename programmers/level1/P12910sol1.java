package level1;

import java.util.Arrays;

public class P12910sol1 {
    public static void main(String[] args) {
        int[] arr1 = {5, 9, 7, 10};
        int[] arr2 = {2, 36, 1, 3};
        int[] arr3 = {3, 2, 6};
        System.out.println(Arrays.toString(solution(arr1, 5)));
        System.out.println(Arrays.toString(solution(arr2, 1)));
        System.out.println(Arrays.toString(solution(arr3, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr).filter(element -> element % divisor == 0).sorted().toArray();
        return result.length == 0 ? new int[] {-1} : result;
    }
}
