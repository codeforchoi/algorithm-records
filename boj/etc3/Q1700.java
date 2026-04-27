package etc3;

import java.io.*;
import java.util.*;

//
public class Q1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> plug = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int now = arr[i];

            // 이미 꽂혀 있음
            if (plug.contains(now)) continue;

            // 빈 자리 있음
            if (plug.size() < N) {
                plug.add(now);
                continue;
            }

            // 뽑을 기기 찾기
            int target = -1;
            int farthest = -1;

            for (int device : plug) {
                int nextIdx = Integer.MAX_VALUE;
                for (int j = i + 1; j < K; j++) {
                    if (arr[j] == device) {
                        nextIdx = j;
                        break;
                    }
                }
                // 다시 안 나오면 최우선 제거
                if (nextIdx == Integer.MAX_VALUE) {
                    target = device;
                    break;
                }
                // 가장 늦게 쓰이는 기기 선택
                if (nextIdx > farthest) {
                    farthest = nextIdx;
                    target = device;
                }
            }
            plug.remove(target);
            plug.add(now);
            answer++;
        }
        System.out.println(answer);
    }
}
