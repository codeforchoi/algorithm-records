package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14581sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String id = br.readLine();
        sb.append(":fan::fan::fan:\n:fan::" + id + "::fan:\n:fan::fan::fan:");
        System.out.println(sb);
    }
}
