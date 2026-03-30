package ex14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for (String s : list) {
            sb.append(s).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}