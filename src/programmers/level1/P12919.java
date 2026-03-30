package programmers.level1;

import java.util.Arrays;

public class P12919 {
    public static void main(String[] args) {
        String[] arr = {"Jane", "Kim"};
        System.out.println(solution(arr));
    }

    public static String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }
}
