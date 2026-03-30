package level1;

public class P87839sol1 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        int x = 2;
        while (true) {
            if (n % x == 1) {
                return x;
            }
            x++;
        }
    }
}
