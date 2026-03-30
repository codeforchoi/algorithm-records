package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isL = false;
        boolean isK = false;
        boolean isP = false;
        for (int i = 0; i < 3; i++) {
            char ch = br.readLine().charAt(0);
            if (ch == 'l') {
                isL = true;
            } else if (ch == 'k') {
                isK = true;
            } else if (ch == 'p') {
                isP = true;
            }
        }
        System.out.println(isL && isK && isP ? "GLOBAL" : "PONIX");
    }
}
