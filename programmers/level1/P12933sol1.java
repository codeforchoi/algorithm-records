package programmers.level1;

import java.util.Arrays;

public class P12933sol1 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);
        for (String s : list) sb.append(s);
        return Long.parseLong(sb.reverse().toString());
    }
}
