package etc2;

import java.io.*;
import java.util.*;

public class Q12100 {
    static int N;
    static int[][] board;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(maxValue);
    }

    private static void dfs(int depth, int[][] map) {
        int max = 0;
        for (int[] row : map) {
            for (int val : row) {
                max = Math.max(max, val);
            }
        }

        // max * 2^(남은 횟수) <= 현재 최대값이면 더 탐색하지 않고 중단한다.
        if(max * (1 << (5 - depth)) <= maxValue) return;

        // 5번 이동이 끝나면 최대값을 비교해 갱신한다.
        if (depth == 5) {
            maxValue = Math.max(maxValue, max);
            return;
        }

        // 상하좌우 다 이동시켜본다.
        for (int i = 0; i < 4; i++) {
            int[][] nextMap = move(i, map);
            dfs(depth + 1, nextMap);
        }
    }

    // 0: 상, 1: 하, 2: 좌, 3: 우
    private static int[][] move(int dir, int[][] map) {
        int[][] newMap = new int[N][N];

        switch(dir) {
            case 0: // 상
                for (int i = 0; i < N; i++) {
                    int index = 0; // 배열 앞쪽으로 몰림.
                    int last = 0;
                    for (int j = 0; j < N; j++) {
                        // 빈칸일 경우
                        if(map[j][i] == 0) continue;

                        // 마지막 값이랑 현재 블럭의 값이 같을 경우 한칸 위에 합친 값을 넣는다.
                        if (last == map[j][i]) {
                            newMap[index - 1][i] = last * 2;
                            last = 0;
                        } else { // 마지막 값이랑 현재 블럭의 값 다를 경우 해당 칸에 값을 유지해서 넣는다.
                            newMap[index++][i] = map[j][i];
                            last = map[j][i];
                        }
                    }
                }
                break;
            case 1: // 하
                for (int i = 0; i < N; i++) {
                    int index = N - 1; // 배열 뒤쪽으로 몰림.
                    int last = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if(map[j][i] == 0)  continue;

                        if (last == map[j][i]) {
                            newMap[index + 1][i] = last * 2;
                            last = 0;
                        } else {
                            newMap[index--][i] = map[j][i];
                            last = map[j][i];
                        }
                    }
                }
                break;
            case 2: // 좌
                for (int i = 0; i < N; i++) {
                    int index = 0; // 배열 앞쪽으로 몰림.
                    int last = 0;
                    for (int j = 0; j < N; j++) {
                        if(map[i][j] == 0) continue;

                        if (last == map[i][j]) {
                            newMap[i][index - 1] = last * 2;
                            last = 0;
                        } else {
                            newMap[i][index++] = map[i][j];
                            last = map[i][j];
                        }
                    }
                }
                break;
            case 3: // 우
                for (int i = 0; i < N; i++) {
                    int index = N - 1; // 배열 뒤쪽으로 몰림.
                    int last = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if(map[i][j] == 0) continue;

                        if (last == map[i][j]) {
                            newMap[i][index + 1] = last * 2;
                            last = 0;
                        } else {
                            newMap[i][index--] = map[i][j];
                            last = map[i][j];
                        }
                    }
                }
                break;
        }
        return newMap;
    }
}
