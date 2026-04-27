package etc3;

import java.io.*;
import java.util.*;

//
public class Q1114 {
    private static int L, K, C;
    private static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 통나무 길이
        K = Integer.parseInt(st.nextToken()); // 자를 수 있는 지점 개수
        C = Integer.parseInt(st.nextToken()); // 최대 자를 수 있는 횟수

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬을 위해 리스트로 변환 후 0과 L 추가
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int size = list.size();
        positions = new int[size + 2];
        for (int i = 1; i <= size; i++) {
            positions[i] = list.get(i - 1);
        }
        positions[0] = 0;
        positions[size + 1] = L;

        // 이분 탐색
        int low = 0;
        int high = L;
        int ansMaxLog = L;
        int ansFirstCut = L;

        while (low <= high) {
            int mid = (low + high) / 2;
            int firstCut = solve(mid);

            if (firstCut != -1) {
                ansMaxLog = mid;
                ansFirstCut = firstCut;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ansMaxLog + " " + ansFirstCut);
    }

    // mid 길이로 잘랐을 때 가능한지 체크
    // 가능하면 가장 처음 자르는 위치를 반환, 불가능하면 -1 반환
    private static int solve(int mid) {
        int count = 0;
        int lastCutPos = L;
        int firstCutPos = 0;

        // 뒤에서부터 그리디하게 자름
        for (int i = positions.length - 2; i >= 0; i--) {
            int diff = positions[i + 1] - positions[i];

            // 조각 하나가 mid보다 크면 아예 불가능
            if (diff > mid) return -1;

            if (lastCutPos - positions[i] > mid) {
                // 직전 위치(i+1)에서 잘라야 함
                lastCutPos = positions[i + 1];
                count++;
                firstCutPos = lastCutPos;

                if (count > C) return -1; // 횟수 초과
            }
        }

        // 만약 자를 수 있는 횟수가 남았다면, 가장 앞쪽의 절단 가능 지점을 선택
        if (count < C) {
            firstCutPos = positions[1];
        }

        return firstCutPos;
    }
}
