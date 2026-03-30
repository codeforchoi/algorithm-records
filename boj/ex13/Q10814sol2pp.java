package ex13;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10814sol2pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        StringBuilder[] person = new StringBuilder[201];
        for (int i = 0; i < person.length; i++) {
            person[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            person[age].append(age + " " + name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder p : person) {
            sb.append(p);
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
