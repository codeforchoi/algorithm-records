package level1;

public class P70128 {
    public static void main(String[] args) {
        int[] arr1_1 = {1, 2, 3, 4};
        int[] arr1_2 = {-3, -1, 0, 2};
        int[] arr2_1 = {-1, 0, 1};
        int[] arr2_2 = {1, 0, -1};
        System.out.println(solution(arr1_1, arr1_2));
        System.out.println(solution(arr2_1, arr2_2));
    }

    public static int solution(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}
