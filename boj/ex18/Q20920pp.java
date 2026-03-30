package ex18;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20920pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (w1, w2) -> {
            if (map.get(w1) == map.get(w2)) {
                if (w1.length() == w2.length()) {
                    return w1.compareTo(w2); // 3. 사전 순으로 앞에 있는 단어를 앞에 배치
                } else {
                    return w2.length() - w1.length(); // 2. 길이가 길수록 앞에 배치
                }
            } else {
                return map.get(w2) - map.get(w1); // 1. 자주 나올 수록 앞에 배치
            }
        } );
        /*list.sort((w1, w2) -> {
            if (map.get(w1) != map.get(w2)) {
                return map.get(w2) - map.get(w1);
            }
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }
            return w1.compareTo(w2);
        });*/

        for (String str : list) {
            sb.append(str).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}