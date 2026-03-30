package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            result -= Integer.parseInt(br.readLine());
        }
        System.out.println(result);
    }
}
