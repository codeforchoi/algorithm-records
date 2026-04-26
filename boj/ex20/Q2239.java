package ex20;

import java.io.*;
import java.util.*;

public class Q2239 {
    private static final int N = 9;
    private static int[][] board = new int[N][N];
    private static List<int[]> unsolved = new ArrayList<>();
    private static boolean finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] == 0) {
                    unsolved.add(new int[]{i, j});
                }
            }
        }

        solve(0);
        if(finished) printSudokuBoard();
    }

    private static void solve(int index) {
        if (index == unsolved.size()) {
            finished = true;
            return;
        }

        int x = unsolved.get(index)[0];
        int y = unsolved.get(index)[1];

        // 1부터 9까지 넣어봄
        for (int i = 1; i <= 9; i++) {
            if (isValid(x, y, i)) {
                board[x][y] = i;
                solve(index + 1);
                if(finished) return;
                board[x][y] = 0; // 완료되지 않았다면 원상복구
            }
        }
    }

    private static boolean isValid(int x, int y, int num) {
        // 행과 열 검사
        for (int i = 0; i < N; i++) {
            if(board[x][i] == num || board[i][y] == num) return false;
        }

        // 3 x 3 사각형 검사
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

    private static void printSudokuBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
