package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ab = Long.parseLong(st.nextToken() + st.nextToken());
        long cd = Long.parseLong(st.nextToken() + st.nextToken());
        System.out.println(ab + cd);
    }
}
