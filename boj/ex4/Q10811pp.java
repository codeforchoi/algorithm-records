package ex4;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10811pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            while (left < right) {
                int temp = list[left];
                list[left++] = list[right];
                list[right--] = temp;
            }
        }

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            if (i != (list.length - 1)) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}