package ex32;

import java.io.*;
import java.util.*;

// 최장 증가 부분 수열(Longest Increasing Subsequence, LIS)
// 원소들 출력을 위한 역추적
// [10, 20, 30, 1] 이라면 10 20 30 이 나와야 하지만 lis에는 1, 20, 30이 되므로
// 이를 인덱스를 저장해 역추적해 2-1-0 순인 원소를 찾는다.
public class Q14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] indexArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int x = arr[i];
            int left = 0, right = size;

            while (left < right) {
                int mid = (left + right) / 2;
                if(lis[mid] < x) left = mid + 1;
                else right = mid;
            }
            lis[left] = x;
            indexArr[i] = left; // i번째 원소의 lis에 들어간 위치 기록
            if(left == size) size++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");

        // 역추적
        int[] result = new int[size];
        int targetIndex = size - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (indexArr[i] == targetIndex) {
                result[targetIndex] = arr[i];
                targetIndex--;
            }
        }

        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
