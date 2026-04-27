package etc3;

import java.io.*;
import java.util.*;

//
public class Q17143 {
    private static int R, C, M;
    private static ArrayList<Shark> sharks = new ArrayList<>();
    private static int[][] board;

    private static int[] dr = {0, -1, 1, 0, 0};
    private static int[] dc = {0, 0, 0, 1, -1};

    private static class Shark {
        int r, c, s, d, z;
        boolean alive = true;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[R + 1][C + 1];

        sharks.add(null); // 1번부터 사용

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, z);
            sharks.add(shark);
            board[r][c] = i;
        }

        int answer = 0;

        for (int king = 1; king <= C; king++) {

            // 낚시왕이 상어 잡기
            for (int row = 1; row <= R; row++) {
                if (board[row][king] != 0) {
                    int idx = board[row][king];
                    Shark s = sharks.get(idx);
                    s.alive = false;
                    answer += s.z;
                    board[row][king] = 0;
                    break;
                }
            }

            // 상어 이동
            int[][] nextBoard = new int[R + 1][C + 1];

            for (int i = 1; i <= M; i++) {
                Shark sh = sharks.get(i);
                if (!sh.alive) continue;

                move(sh);

                int r = sh.r;
                int c = sh.c;

                if (nextBoard[r][c] == 0) {
                    nextBoard[r][c] = i;
                } else {
                    int otherIdx = nextBoard[r][c];
                    Shark other = sharks.get(otherIdx);

                    if (other.z > sh.z) {
                        sh.alive = false;
                    } else {
                        other.alive = false;
                        nextBoard[r][c] = i;
                    }
                }
            }

            board = nextBoard;
        }

        System.out.println(answer);
    }

    private static void move(Shark sh) {

        int speed = sh.s;

        if (sh.d == 1 || sh.d == 2) {
            speed %= (R - 1) * 2;
        } else {
            speed %= (C - 1) * 2;
        }

        for (int i = 0; i < speed; i++) {
            int nr = sh.r + dr[sh.d];
            int nc = sh.c + dc[sh.d];

            if (nr < 1 || nr > R || nc < 1 || nc > C) {
                if (sh.d == 1) sh.d = 2;
                else if (sh.d == 2) sh.d = 1;
                else if (sh.d == 3) sh.d = 4;
                else sh.d = 3;

                nr = sh.r + dr[sh.d];
                nc = sh.c + dc[sh.d];
            }

            sh.r = nr;
            sh.c = nc;
        }
    }

}
