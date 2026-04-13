package level1;

import java.util.Arrays;

public class P12940 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static int[] solution(int n, int m) {
        int[] result = new int[2];
        int nm = n * m;
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        result[0] = n;
        result[1] = nm / n;
        return result;
    }
}
