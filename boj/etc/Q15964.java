package etc;

import java.io.*;
import java.util.*;

public class Q15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(calculate(a, b));
    }

    private static long calculate(long a, long b) {
        return (a + b) * (a - b);
    }
}
