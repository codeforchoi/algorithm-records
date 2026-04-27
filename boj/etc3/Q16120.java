package etc3;

import java.io.*;

//
public class Q16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= 4) {
                // 마지막 4글자가 PPAP인지 확인
                if (sb.substring(sb.length() - 4).equals("PPAP")) {
                    // PPAP를 지우고 P를 다시 넣음
                    sb.delete(sb.length() - 4, sb.length());
                    sb.append('P');
                }
            }
        }

        if (sb.toString().equals("P")) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
