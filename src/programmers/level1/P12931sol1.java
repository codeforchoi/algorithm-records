package programmers.level1;

public class P12931sol1 {
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').sum();
    }
}
