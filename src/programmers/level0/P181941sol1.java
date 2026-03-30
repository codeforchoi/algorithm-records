package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P181941sol1 {
    public static void main(String[] args) {
        String[] arr = {"a","b","c"};
        System.out.println(solution(arr));
    }

    public static String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
