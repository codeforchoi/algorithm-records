package programmers.level0;

public class P181936 {
    public static void main(String[] args) {
        System.out.println(solution(60, 2, 3));
    }

    public static int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }
}
