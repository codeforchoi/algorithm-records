package ex30;

import java.io.*;
import java.util.*;

// 시간 초과 방지를 위한 방법 (전체 경우의 수 4000 ^ 4 = 2.56 * 10^14) long타입은 9.22 * 10^18
public class Q7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        // A와 B의 합 조합, C와 D의 합 조합
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        // 투 포인터 사용
        // AB정렬 시켜놓고 CD에서 이분탐색도 가능 (upper bound, lower bound)
        long count = 0;
        int left = 0;
        int right = n * n - 1;
        while (left < n * n && right >= 0) {
            int sum = AB[left] + CD[right];

            // 합이 0인 것을 찾으면 각 AB, CD 배열에서 똑같은 합 값이 있는지 확인
            if (sum == 0) {
                int sumAB = AB[left];
                int sumCD = CD[right];

                long countAB = 0;
                long countCD = 0;

                // 정렬 되어있으므로 같은 값이 연속되어 있을 것이다.
                // AB에서 sumAB와 똑같은 값 개수 찾기
                while (left < n * n && AB[left] == sumAB) {
                    countAB++;
                    left++;
                }

                // CD에서 sumCD와 똑같은 값 개수 찾기
                while (right >= 0 && CD[right] == sumCD) {
                    countCD++;
                    right--;
                }
                // 개수 * 개수 = 전체 쌍 개수
                count += countAB * countCD;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
