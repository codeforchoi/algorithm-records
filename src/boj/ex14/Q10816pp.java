package boj.ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> ownedCard = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            // getOrDefault(key, 0) 메서드
            // key 키가 있으면 value값을 반환하고, 없으면 두번째 인자인 0을 반환
            ownedCard.put(key, ownedCard.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(ownedCard.getOrDefault(key, 0)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}