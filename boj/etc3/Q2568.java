package etc3;

import java.io.*;
import java.util.*;

//
public class Q2568 {
    private static class Wire {
        int a, b;
        Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Wire[] arr = new Wire[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Wire(a, b);
        }

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.a, o2.a));

        List<Integer> lis = new ArrayList<>();
        int[] idx = new int[N];

        for (int i = 0; i < N; i++) {
            int pos = lowerBound(lis, arr[i].b);
            if (pos == lis.size()) lis.add(arr[i].b);
            else lis.set(pos, arr[i].b);
            idx[i] = pos;
        }

        int target = lis.size() - 1;
        boolean[] keep = new boolean[N];

        for (int i = N - 1; i >= 0; i--) {
            if (idx[i] == target) {
                keep[i] = true;
                target--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - lis.size()).append('\n');
        for (int i = 0; i < N; i++) {
            if (!keep[i]) sb.append(arr[i].a).append('\n');
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}
