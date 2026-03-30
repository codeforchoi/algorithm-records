package ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7785sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> workingList = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            // 이미 key가 있다면 leave 하는 것이므로 제거해준다.
            if (workingList.containsKey(name)) {
                workingList.remove(name);
            } else {
                workingList.put(name, st.nextToken());
            }
        }

        List<String> keyList = new ArrayList<>(workingList.keySet());
        Collections.sort(keyList, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : keyList) {
            sb.append(s).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}