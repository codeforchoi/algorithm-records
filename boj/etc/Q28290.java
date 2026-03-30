package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        if (input.equals("fdsajkl;") || input.equals("jkl;fdsa")) {
            sb.append("in-out");
        } else if (input.equals("asdf;lkj") || input.equals(";lkjasdf")) {
            sb.append("out-in");
        } else if (input.equals("asdfjkl;")) {
            sb.append("stairs");
        } else if (input.equals(";lkjfdsa")) {
            sb.append("reverse");
        } else {
            sb.append("molu");
        }
        System.out.println(sb);
    }
}
