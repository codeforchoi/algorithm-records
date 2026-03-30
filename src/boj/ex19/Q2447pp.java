package boj.ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2447pp {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        StringBuilder sb = new StringBuilder();

        // 공백으로 모두 채운다.
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        // 별을 채워야할 곳에 별을 채워 만든다.
        makeStar(0, 0, n);

        // 만든 별을 sb에 넣고 출력한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void makeStar(int x, int y, int size) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        size /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    makeStar(x + i * size, y + j * size, size);
                }
            }
        }
    }
}