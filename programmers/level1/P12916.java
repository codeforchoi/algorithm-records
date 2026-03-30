package programmers.level1;

public class P12916 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        long p = s.toUpperCase().chars().filter(c -> c == 'P').count();
        long y = s.toUpperCase().chars().filter(c -> c == 'Y').count();
        return (p == y);
    }
}
