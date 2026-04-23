package etc;

import java.io.*;
import java.util.*;

public class Q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] uniqueIds = new int[5];
        for (int i = 0; i < 5; i++) {
            uniqueIds[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(generateCheckDigit(uniqueIds));
    }

    private static int generateCheckDigit(int[] ids) {
        int sum = 0;
        for (int id : ids) {
            sum += Math.pow(id, 2);
        }
        return sum % 10;
    }
}
