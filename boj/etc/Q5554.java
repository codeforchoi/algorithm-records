package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int totalSec = 0;
        for (int i = 0; i < 4; i++) {
            totalSec += Integer.parseInt(br.readLine());
        }
        sb.append(totalSec / 60).append("\n").append(totalSec % 60);
        System.out.println(sb);
    }
}
