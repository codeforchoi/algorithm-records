package etc3;

import java.io.*;
import java.util.*;

//
public class Q16496 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 모두 0인 경우 처리
        if (arr[0].equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
