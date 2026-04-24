package etc;

import java.io.*;
import java.util.*;

public class Q2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] music = new int[8];
        for (int i = 0; i < 8; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 0; i < 7; i++) {
            if (music[i] + 1 != music[i + 1]) {
                asc = false;
            }
            if (music[i] - 1 != music[i + 1]) {
                desc = false;
            }
        }

        System.out.println(asc ? "ascending" : desc ? "descending" : "mixed");
    }
}
