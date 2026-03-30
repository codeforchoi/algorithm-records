package ex14;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10815pp {
    static int n, m;
    static int[] ownedCard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        ownedCard = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ownedCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ownedCard);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int binarySearch(int num) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = ownedCard[middle];

            if (num > middleValue) {
                left = middle + 1;
            } else if (num < middleValue) {
                right = middle - 1;
            } else {    // 찾았을 경우
                return 1;
            }
        }
        return 0;
    }
}
