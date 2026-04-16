package ex20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    static int n;
    static int count = 0;
    static int[] board; // index: row, value: column

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];
        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int row) {
        // 각 행에 모두 배치하면 경우의 수를 찾은 것이므로 count 증가하고 return
        if (row == n) {
            count++;
            return;
        }

        // 해당 행의 각 열에 배치해보고 가능하면 다음행으로 진행
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValid(row)) {
                dfs(row + 1);
            }
        }
    }

    private static boolean isValid(int row) {
        // 해당 행 이전 행에 배치된 퀸들과 유효성 확인
        for (int i = 0; i < row; i++) {
            // 같은 열에 배치되었으면 false
            if (board[row] == board[i]) {
                return false;
            }
            // 대각선에 배치되었으면 false
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
