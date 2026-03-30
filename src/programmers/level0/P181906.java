package programmers.level0;

public class P181906 {
    public static void main(String[] args) {
        System.out.println(solution("banana", "ban"));
    }

    public static int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}
