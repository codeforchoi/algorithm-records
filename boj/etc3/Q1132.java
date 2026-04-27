package etc3;

import java.util.*;
import java.io.*;

//
public class Q1132 {
    private static class Alpha implements Comparable<Alpha> {
        long weight = 0;
        boolean canBeZero = true;

        @Override
        public int compareTo(Alpha o) {
            return Long.compare(o.weight, this.weight); // 가중치 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        Alpha[] alphas = new Alpha[10];

        for (int i = 0; i < 10; i++) alphas[i] = new Alpha();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            long power = 1;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int idx = words[i].charAt(j) - 'A';
                alphas[idx].weight += power;
                if (j == 0) alphas[idx].canBeZero = false; // 첫 글자는 0 불가
                power *= 10;
            }
        }

        // 1. 0을 배정할 알파벳 결정
        // 가중치가 0이 아닌 알파벳이 10개인 경우, 0을 누군가에게는 줘야 함
        int zeroIdx = -1;
        long minWeight = Long.MAX_VALUE;

        // 가중치가 있는 알파벳들 중에서, 0이 될 수 있는(canBeZero == true)
        // 알파벳 중 가장 가중치가 낮은 놈을 찾음
        for (int i = 0; i < 10; i++) {
            if (alphas[i].canBeZero && alphas[i].weight < minWeight) {
                minWeight = alphas[i].weight;
                zeroIdx = i;
            }
        }

        // 0으로 만들 놈의 가중치를 0으로 만들어서 정렬에서 밀려나게 함
        if (zeroIdx != -1) {
            alphas[zeroIdx].weight = 0;
        }

        // 2. 가중치 순으로 정렬 후 9부터 곱함
        Arrays.sort(alphas);

        long totalSum = 0;
        int num = 9;
        for (int i = 0; i < 10; i++) {
            if (alphas[i].weight == 0) break;
            totalSum += alphas[i].weight * num--;
        }
        System.out.println(totalSum);
    }

}
