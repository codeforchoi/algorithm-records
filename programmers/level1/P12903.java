package level1;

public class P12903 {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

    public static String solution(String s) {
        int half = s.length() / 2;
        return (s.length() % 2 == 0) ? s.substring(half - 1, half + 1) : s.substring(half, half + 1);
    }

}
