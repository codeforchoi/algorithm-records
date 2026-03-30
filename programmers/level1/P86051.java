package level1;

public class P86051 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] arr2 = {5, 8, 4, 0, 6, 7, 9};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static int solution(int[] numbers) {
        int sum = 45;
        for (int num : numbers) sum -= num;
        return sum;
    }
}
