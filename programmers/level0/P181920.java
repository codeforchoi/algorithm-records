package programmers.level0;


import java.util.Arrays;
import java.util.stream.IntStream;

public class P181920 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 10)));
    }

    public static int[] solution(int start_num, int end_num) {
        return start_num <= end_num
                ? IntStream.rangeClosed(start_num, end_num).toArray()
                : IntStream.rangeClosed(end_num, start_num).toArray();
    }
}
