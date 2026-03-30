package boj.ex12;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] chess = new boolean[n][m];
        int min = 64;

        for (int i = 0; i < n; i++) {
            String ondLine = br.readLine();
            for (int j = 0; j < m; j++) {
                if (ondLine.charAt(j) == 'W') {
                    chess[i][j] = true;     // W일 경우 true
                } else {
                    chess[i][j] = false;    // B일 경우 false
                }
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;

        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                int end_row = i + 8;
                int end_col = j + 8;
                int count = 0;
                boolean tf = chess[i][j];

                for (int k = i; k < end_row; k++) {
                    for (int l = j; l < end_col; l++) {
                        if (chess[k][l] != tf) {
                            count++;
                        }
                        // 다음칸은 전칸과 색깔 반대
                        tf = !tf;
                    }
                    // 8칸이므로 다음줄 첫번째는 첫번째와 반대
                    tf = !tf; 
                }
                // 해당 case 8칸 체스판의 최솟값을 처음이 W or B인 경우 계산
                count = Math.min(count, 64 - count);
                // 이전 case 8칸 체스판보다 최솟값이 작으면 갱신
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
}