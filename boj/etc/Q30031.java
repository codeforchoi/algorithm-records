package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int  total = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch(Integer.parseInt(st.nextToken())) {
                case 136: total += 1000; break;
                case 142: total += 5000; break;
                case 148: total += 10000; break;
                case 154: total += 50000; break;
                default:
            }
        }
        System.out.println(total);
    }
}
