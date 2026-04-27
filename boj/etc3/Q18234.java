package etc3;

import java.io.*;
import java.util.*;

//
public class Q18234 {
    private static class Carrot {
        long w, p;

        Carrot(long w, long p) {
            this.w = w;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Carrot[] arr = new Carrot[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long w = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            arr[i] = new Carrot(w, p);
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a.p, b.p));

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += arr[i].w + arr[i].p * (T - N + i);
        }
        System.out.println(answer);
    }
}
