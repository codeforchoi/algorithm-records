package level1;

public class P12934 {
    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }

    public static long solution(long n) {
        long x = (long) Math.sqrt(n);
        return x * x == n ? (long) Math.pow(x + 1, 2) : -1;
    }
}
