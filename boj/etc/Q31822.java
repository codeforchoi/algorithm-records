package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine().substring(0, 5);
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String code = br.readLine().substring(0, 5);
            if (target.equals(code)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
