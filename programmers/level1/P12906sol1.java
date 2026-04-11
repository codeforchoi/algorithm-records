package level1;

import java.util.Arrays;
import java.util.Stack;


public class P12906sol1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n) {
                stack.push(n);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
