package level1;

import java.util.Arrays;

public class P12917 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder(String.valueOf(arr)).reverse().toString();
    }
}
