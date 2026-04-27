package etc3;

import java.io.*;

//
public class Q9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();       // 전체 문자열
        String bomb = br.readLine();      // 폭발 문자열
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)); // 일단 문자를 하나씩 담음

            // 스택(sb)의 길이가 폭발 문자열보다 길어지면 체크 시작
            if (sb.length() >= bombLen) {
                boolean isMatch = true;

                // 뒤에서부터 bombLen만큼 비교
                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                // 일치하면 폭발 문자열만큼 제거
                if (isMatch) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }

}
