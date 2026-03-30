package ex13;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10814pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] person = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = st.nextToken();
            person[i][1] = st.nextToken();
        }

        Arrays.sort(person, (p1, p2) -> Integer.parseInt(p1[0]) - Integer.parseInt(p2[0]));

        for (int i = 0; i < n; i++) {
            sb.append(person[i][0] + " " + person[i][1]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}