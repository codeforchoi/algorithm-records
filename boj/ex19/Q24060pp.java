package ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q24060pp {
    static int[] temp;
    static int k;
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    public static void merge_sort(int[] arr, int p, int r) {
        if (count > k) return;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        
        // 왼쪽 배열이 남은 경우
        while (i <= q) {
            temp[t++] = arr[i++];
        }
        
        // 오른쪽 배열이 남은 경우
        while (j <= r) {
            temp[t++] = arr[j++];
        }

        // 정렬한 것을 arr에 옮긴다.
        i = p;
        t = 0;
        while (i <= r) {
            count++;
            if (count == k) {
                result = temp[t];
                return;
            }
            arr[i++] = temp[t++];
        }
    }
}