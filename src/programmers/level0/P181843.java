package programmers.level0;

public class P181843 {
    public static void main(String[] args) {
        System.out.println(solution("banana", "ana"));
    }

    public static int solution(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
}
