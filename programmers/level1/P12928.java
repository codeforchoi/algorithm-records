package programmers.level1;

public class P12928 {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int result = 0;
        for(int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        return result + n;
    }
}
