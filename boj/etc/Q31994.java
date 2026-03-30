package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q31994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        String maxName = "";
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (count > max) {
                max = count;
                maxName = name;
            }
        }
        System.out.println(maxName);
    }
}
