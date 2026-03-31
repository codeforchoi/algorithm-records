package level1;

public class P12943 {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        if (num == 1) return 0;

        long n = num;
        int count = 0;
        while (count < 501) {
            if(n == 1) break;
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
            count++;
        }
        if(count > 500) count = -1;
        return count;
    }
}
