package programmers.level0;

public class P181908 {
    public static void main(String[] args) {
        System.out.println(solution("banana", "ana"));
    }

    public static int solution(String my_string, String is_suffix) {
        return my_string.length() < is_suffix.length() ? 0 : my_string.substring(my_string.length() - is_suffix.length()).equals(is_suffix) ? 1 : 0;
    }
}
