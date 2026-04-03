package ex05;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11718pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        int count = 0;

        // EOF 처리는 Ctrl + D 단출키를 사용하면 된다.
        while ((str = br.readLine()) != null && !str.equals("")) {
            sb.append(str.trim()).append("\n");
            count++;
            if (count > 100) {
                break;
            }
        }
        System.out.println(sb);
    }
}