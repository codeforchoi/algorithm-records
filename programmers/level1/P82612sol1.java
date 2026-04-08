package level1;

public class P82612sol1 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        return Math.max((long) price * count * (count + 1) / 2 - money, 0);
    }
}
