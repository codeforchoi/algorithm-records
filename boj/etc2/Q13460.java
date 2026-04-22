package etc2;

import java.io.*;
import java.util.*;

// 삼성SW역량테스트 기출 문제
// 최소를 구하므로 BFS를 사용
public class Q13460 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    private static final int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static final int[] dy = {0, 0, -1, 1};

    private static class Marble {
        int rx, ry, bx, by, depth;

        public Marble(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M]; // [rx, ry, bx, by]
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.'; // R을 . 처리
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.'; // B를 . 처리
                }
            }
        }

        Queue<Marble> q = new ArrayDeque<>();
        q.offer(new Marble(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Marble cur = q.poll();

            // 10회 이상인 경우 실패 처리
            if(cur.depth >= 10) continue;

            // 4방향으로 모두 이동시켜본다.
            for (int i = 0; i < 4; i++) {
                int[] r = move(cur.rx, cur.ry, dx[i], dy[i]);
                int[] b = move(cur.bx, cur.by, dx[i], dy[i]);

                // 움직인 결과 변수에 저장 [x위치, y위치, 움직인 거리(횟수)]
                int nrx = r[0], nry = r[1], rc = r[2];
                int nbx = b[0], nby = b[1], bc = b[2];

                // 파란 구슬이 구멍에 빠지면 실패 처리
                if(map[nbx][nby] == 'O') continue;

                // 빨간 구슬이 구멍에 빠지면 성공 처리
                if (map[nrx][nry] == 'O') {
                    System.out.println(cur.depth + 1);
                    return;
                }

                // 빨간 구슬과 파란 구슬이 겹치면 조정
                // 이미 위치가 다르므로 같은 횟수로 같은 위치일 수 없다.)
                if (nrx == nbx && nry == nby) {
                    // 빨간 구슬이 더 뒤였을 경우
                    if (rc > bc) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else { // 파란 구슬이 더 뒤였을 경우
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                // 방문 처리
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new Marble(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }
        System.out.println(-1);
    }

    // 구슬 이동 [움직인 x위치, 움직인 y위치, 움직인 거리(횟수)]
    private static int[] move(int x, int y, int dx, int dy) {
        int count = 0;
        while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
        }
        return new int[]{x, y, count};
    }
}
