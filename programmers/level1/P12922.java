package level1;

public class P12922 {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i % 2 != 0 ? "수" : "박");
        }
        return sb.toString();
    }
}
