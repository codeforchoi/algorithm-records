package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int men = Integer.parseInt(st.nextToken());
            int women = Integer.parseInt(st.nextToken());
            if (men == 0 && women == 0) {
                break;
            }
            sb.append(men + women).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
