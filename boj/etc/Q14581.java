package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String id = br.readLine();
        String emoji = ":fan:";
        sb.append(emoji + emoji + emoji).append("\n");
        sb.append(emoji + ":" + id + ":" + emoji).append("\n");
        sb.append(emoji + emoji + emoji).append("\n");
        System.out.println(sb);
    }
}
