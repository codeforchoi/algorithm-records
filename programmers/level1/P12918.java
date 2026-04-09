package level1;

public class P12918 {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.matches("\\d+");
    }
}
