package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dir = 0;
        for (int i = 0; i < 10; i++) {
            int t = Integer.parseInt(br.readLine());
            dir += t;
        }
        dir %= 4;
        if (dir == 0) {
            System.out.println("N");
        } else if (dir == 1) {
            System.out.println("E");
        } else if (dir == 2) {
            System.out.println("S");
        } else {
            System.out.println("W");
        }
    }
}
