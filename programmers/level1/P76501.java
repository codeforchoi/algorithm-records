package level1;

public class P76501 {
    public static void main(String[] args) {
        int[] arr1_1 = {4, 7, 12};
        boolean[] arr1_2 = {true, false, true};
        int[] arr2_1 = {1, 2, 3};
        boolean[] arr2_2 = {false, false, true};
        System.out.println(solution(arr1_1, arr1_2));
        System.out.println(solution(arr2_1, arr2_2));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += absolutes[i] * (signs[i] ? 1 : - 1);
        }
        return sum;
    }
}
