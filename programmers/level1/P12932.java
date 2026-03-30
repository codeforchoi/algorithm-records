package level1;

import java.util.Arrays;

public class P12932 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - i - 1] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}
