package ex13;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q11650pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] point = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            } else {
                return p1[0] - p2[0];
            }
        });

/*        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if(p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                }
                else {
                    return p1[0] - p2[0];
                }
            }
        });*/

        for (int i = 0; i < n; i++) {
            sb.append(point[i][0] + " " + point[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}