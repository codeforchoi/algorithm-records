package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30794 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        int score = 0;
        if (str.equals("miss")) {
            score = 0;
        } else if (str.equals("bad")) {
            score += 200 * lv;
        } else if (str.equals("cool")) {
            score += 400 * lv;
        } else if (str.equals("great")) {
            score += 600 * lv;
        } else {
            score += 1000 * lv;
        }
        System.out.println(score);
    }
}
