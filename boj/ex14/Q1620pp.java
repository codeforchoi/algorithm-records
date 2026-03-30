package ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> pokemon1 = new HashMap<>();
        Map<String, Integer> pokemon2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pokemon1.put(i, name);
            pokemon2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String problem = br.readLine();
            if (Character.isDigit(problem.charAt(0))) {
                sb.append(pokemon1.get(Integer.parseInt(problem)));
            } else {
                sb.append(pokemon2.get(problem));
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}