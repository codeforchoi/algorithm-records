package d2;

import java.io.*;
import java.util.*;

public class S12712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // +스프레이 (상, 하, 좌, 우)
        int[] dxPlus = {-1, 1, 0, 0};
        int[] dyPlus = {0, 0, -1, 1};

        // x스프레이 (좌상, 우상, 좌하, 우하)
        int[] dxCross = {-1, -1, 1, 1};
        int[] dyCross = {-1, 1, -1, 1};

        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sumPlus = map[i][j]; // 중심부
                    int sumCross = map[i][j]; // 중심부

                    // + 스프레이
                    for (int d = 0; d < 4; d++) {
                        // M 세기 (중심부 제외)
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxPlus[d] * k;
                            int ny = j + dyPlus[d] * k;

                            // 맵을 벗어나는 경우
                            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                            sumPlus += map[nx][ny];
                        }
                    }

                    // x 스프레이
                    for (int d = 0; d < 4; d++) {
                        // M 세기 (중심부 제외)
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxCross[d] * k;
                            int ny = j + dyCross[d] * k;

                            // 맵을 벗어나는 경우
                            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                            sumCross += map[nx][ny];
                        }
                    }
                    max = Math.max(max, Math.max(sumPlus, sumCross));
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
