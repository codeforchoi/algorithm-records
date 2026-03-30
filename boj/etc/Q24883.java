package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char ch = input.charAt(0);
        System.out.println(ch == 'N' | ch == 'n' ? "Naver D2" : "Naver Whale");
    }
}
