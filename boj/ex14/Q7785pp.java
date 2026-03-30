package boj.ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7785pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> workingList = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            workingList.put(st.nextToken(), st.nextToken());
            // put()메서드는 같은 키가 이미 존재하는 경우 매핑되는 값이 변경된다.
        }

        List<String> keyList = new ArrayList<>(workingList.keySet());
        Collections.sort(keyList, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : keyList) {
            if (workingList.get(s).equals("enter")) {
                sb.append(s).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}