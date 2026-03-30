package ex13;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q18870pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        // 정렬된 배열을 순회하면서 map에 없으면 넣고 count를 해준다.
        int count = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, count);
                count++;
            }
        }

        // 원본 배열을 순회하면서 map에서 value값을 가져와 sb에 넣는다.
        for (int key : arr) {
            sb.append(map.get(key)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}