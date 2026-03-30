package level0;

public class P181940 {
    public static void main(String[] args) {
        System.out.println(solution("string", 3));
    }

    public static String solution(String my_string, int k) {
        return my_string.repeat(k);
    }
}
