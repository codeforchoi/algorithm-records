package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q33571 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        Set<Character> dimigo = new HashSet<>(List.of('A', 'a', 'B', 'b', 'D', 'd', 'e', 'g', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', '@'));
        int count = 0;
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (dimigo.contains(ch)) {
                if (ch == 'B') {
                    count += 2;
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
