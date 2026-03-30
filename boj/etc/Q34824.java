package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean yonsei = false;
        boolean korea = false;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("yonsei") && !korea) {
                yonsei = true;
                sb.append("Yonsei Won!");
            } else if (str.equals("korea") && !yonsei) {
                korea = true;
                sb.append("Yonsei Lost...");
            }
        }
        System.out.println(sb);
    }
}
