package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P12933 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        List<Long> list = new ArrayList<>();
        long result = 0;
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        result += list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result += (long) (list.get(i) * (Math.pow(10, i)));
        }
        return result;
    }
}
