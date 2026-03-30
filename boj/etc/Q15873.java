package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(1) == '0') {
            System.out.println(10 + Integer.parseInt(str.substring(2)));
        } else {
            System.out.println(str.charAt(0) - '0' + Integer.parseInt(str.substring(1)));
        }
    }
}
