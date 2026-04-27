package etc3;

import java.util.*;
import java.io.*;

public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];

            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers);

            // 인접한 두 번호만 비교
            boolean isConsistent = true;
            for (int i = 0; i < n - 1; i++) {
                // 뒷 번호가 앞 번호로 시작하는지 확인
                if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
