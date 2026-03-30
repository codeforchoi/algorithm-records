package ex13;
//포스팅
// 시간 초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18870sol2pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        // 인덱스가 곧 해당 요소보다 작은 요소의 개수가 되도록 한다.
        int index = 0;
        int prev = sorted[0];
        for (int i = 1; i < n; i++) {
            if (sorted[i] != prev) {
                sorted[++index] = sorted[i];
                prev = sorted[i];
            }
        }

        // 0번 인덱스부터 설정한 index 값까지 탐색해 인덱스 값을 반환해준다.
        for (int num : arr) {
            for (int i = 0; i <= index; i++) {
                if (sorted[i] == num) {
                    sb.append(i).append(" ");
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}