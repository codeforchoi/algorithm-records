package programmers.level0;

public class P181939 {
    public static void main(String[] args) {
        System.out.println(solution(9, 91));
    }

    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(a + "" + b), Integer.parseInt(b + "" + a));
    }
}
