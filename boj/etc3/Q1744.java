package etc3;

import java.io.*;
import java.util.*;

//
public class Q1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 1) plus.add(x);
            else if (x == 1) oneCount++;
            else if (x == 0) zeroCount++;
            else minus.add(x);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int answer = 0;

        // 양수(2 이상)
        for (int i = 0; i + 1 < plus.size(); i += 2) {
            answer += plus.get(i) * plus.get(i + 1);
        }
        if (plus.size() % 2 == 1) {
            answer += plus.get(plus.size() - 1);
        }

        // 1
        answer += oneCount;

        // 음수
        for (int i = 0; i + 1 < minus.size(); i += 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }

        if (minus.size() % 2 == 1) {
            if (zeroCount == 0) {
                answer += minus.get(minus.size() - 1);
            }
        }
        System.out.println(answer);
    }
}
