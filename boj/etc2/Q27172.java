package etc2;

import java.io.*;
import java.util.*;

// 브루트포스로 모든 조합을 진행하면 시간초과
// 약수인 사람은 점수를 얻고 배수인 사람은 점수를 잃는다.
public class Q27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];

        int max = 0; // 최대값을 찾아 존재하는지 저장하는 배열 크기를 정한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, cards[i]);
        }

        int[] score = new int[max + 1];
        boolean[] exist = new boolean[max + 1];
        for (int num : cards) {
            exist[num] = true;
        }

        // 매번 배수가 존재하는지 찾고 그 배수를 가진 플레이어의 인덱스를 구하긴 어려우므로 점수도 max + 1만큼 선언
        // 에라토스테네스의 체 방법 사용, 배수로 걸러낸다.
        for (int i = 0; i < N; i++) {
            int x = cards[i];
            for (int multiple = x * 2; multiple <= max; multiple += x) {
                if (exist[multiple]) {
                    score[x]++;
                    score[multiple]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : cards) {
            sb.append(score[num]).append(" ");
        }
        System.out.println(sb);
    }
}
