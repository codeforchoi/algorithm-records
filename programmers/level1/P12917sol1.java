package level1;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P12917sol1 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        return Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }
}
