package level0;

public class P181938 {
    public static void main(String[] args) {
        System.out.println(solution(2, 91));
    }

    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(String.valueOf(a) + String.valueOf(b)), 2 * a * b);
    }
}
