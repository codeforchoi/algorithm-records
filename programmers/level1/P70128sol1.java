package level1;

import java.util.stream.IntStream;

public class P70128sol1 {
    public static void main(String[] args) {
        int[] arr1_1 = {1, 2, 3, 4};
        int[] arr1_2 = {-3, -1, 0, 2};
        int[] arr2_1 = {-1, 0, 1};
        int[] arr2_2 = {1, 0, -1};
        System.out.println(solution(arr1_1, arr1_2));
        System.out.println(solution(arr2_1, arr2_2));
    }

    public static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
