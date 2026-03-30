package boj.ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] ownedCard = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ownedCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ownedCard);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(ownedCard, target) - lowerBound(ownedCard, target)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = (left + right) / 2;
            // left + right 과정에서 int 범위를 넘어가 overflow가 발생할 수도 있다.
            // 이를 방지하기 위해 다음과 같이 해도 된다.
            // int middle = left + ((right - left) / 2);
            if (target < arr[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target <= arr[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
