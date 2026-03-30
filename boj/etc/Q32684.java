package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] score = { 13, 7, 5, 3, 3, 2};
        int choSum = 0;
        int hanSum = 0;
        for (int i = 0; i < 6; i++) {
            choSum += Integer.parseInt(st.nextToken()) * score[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            hanSum += Integer.parseInt(st.nextToken()) * score[i];
        }
        System.out.println(choSum > hanSum + 1.5 ? "cocjr0208" : "ekwoo");
    }
}
