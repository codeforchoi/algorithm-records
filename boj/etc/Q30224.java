package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        if (!str.contains("7")) {
            if (n % 7 != 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else {
            if (n % 7 != 0) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
