package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String str = br.readLine();
            if (str.contains("01") || str.contains("OI")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
