package ex32;

import java.io.*;
import java.util.*;

public class Q14002 {
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
            int left = 0, rigth = size;

            while (left < rigth) {
                int mid = (left + rigth) / 2;
                if(lis[mid] < x) left = mid + 1;
                else rigth = mid;
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
