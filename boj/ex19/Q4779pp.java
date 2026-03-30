package ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4779pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String str = "-".repeat((int) Math.pow(3, n));
            sb = new StringBuilder();
            cantorSet(sb.append(str), 0, str.length());
            result.append(sb).append("\n");
        }
        System.out.println(result);
    }

    public static void cantorSet(StringBuilder sb, int start, int size) {
        if (size == 1) {
            return;
        }

        size /= 3;
        for (int i = start + size; i < start + 2 * size; i++) {
            sb.setCharAt(i, ' ');
        }

        cantorSet(sb, start, size);
        cantorSet(sb, start + 2 * size, size);
    }
}