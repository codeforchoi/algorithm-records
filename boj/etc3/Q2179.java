package etc3;

import java.io.*;
import java.util.*;

//
public class Q2179 {
    private static class Word implements Comparable<Word> {
        String str;
        int idx;

        Word(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }

        @Override
        public int compareTo(Word o) {
            return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] origin = new String[N];
        List<Word> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine();
            list.add(new Word(origin[i], i));
        }

        // 사전순 정렬
        Collections.sort(list);

        int maxLen = -1;
        int[] commonLen = new int[N]; // 정렬된 상태에서 인접한 단어와의 최대 접두사 길이 저장

        // 인접한 단어끼리 공통 접두사 길이 계산
        for (int i = 0; i < N - 1; i++) {
            int len = getCommonPrefix(list.get(i).str, list.get(i + 1).str);
            maxLen = Math.max(maxLen, len);
        }

        // 원래 순서대로 출력하기 위한 탐색
        // 첫 번째 단어 찾기
        for (int i = 0; i < N; i++) {
            String s1 = origin[i];

            // 이 단어와 접두사가 maxLen인 다른 단어가 뒤에 있는지 확인
            for (int j = i + 1; j < N; j++) {
                String s2 = origin[j];

                if (getCommonPrefix(s1, s2) == maxLen) {
                    System.out.println(s1);
                    System.out.println(s2);
                    return;
                }
            }
        }
    }

    private static int getCommonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }

}
