package ex18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q25192sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> set = new HashSet<>();

        while (n-- > 0) {
            String name = br.readLine();
            if (name.equals("ENTER")) {
                count += set.size();
                set.clear();
                continue;
            }
            set.add(name);
        }
        count += set.size();
        System.out.println(count);
    }
}