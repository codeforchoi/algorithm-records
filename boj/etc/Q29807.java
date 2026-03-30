package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q29807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        int result = 0;

        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] > arr[2]) {
            result += (arr[0] - arr[2]) * 508;
        } else {
            result += (arr[2] - arr[0]) * 108;
        }

        if (arr[1] > arr[3]) {
            result += (arr[1] - arr[3]) * 212;
        } else {
            result += (arr[3] - arr[1]) * 305;
        }

        if (t > 4) {
            result += arr[4] * 707;
        }
        System.out.println(result * 4763);
    }
}
