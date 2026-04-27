package etc3;

import java.io.*;
import java.util.*;

//
public class Q14908 {
    private static class Job {
        int idx, t, s;

        Job(int idx, int t, int s) {
            this.idx = idx;
            this.t = t;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Job[] arr = new Job[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new Job(i + 1, t, s);
        }

        Arrays.sort(arr, (a, b) -> {
            long left = (long)a.s * b.t;
            long right = (long)b.s * a.t;
            if (left == right) {
                return a.idx - b.idx;
            }
            return left > right ? -1 : 1;
        });

        StringBuilder sb = new StringBuilder();
        for (Job job : arr) {
            sb.append(job.idx).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
