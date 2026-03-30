package programmers.level1;

public class P12912 {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
    }

    public static long solution(int a, int b) {
        long result = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            result += i;
        }
        return result;
    }
}
