package level1;

public class P12918sol1 {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        for (char c : s.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
