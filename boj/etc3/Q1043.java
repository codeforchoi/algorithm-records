package etc3;

import java.util.*;
import java.io.*;

//
public class Q1043 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 정보
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        if (truthCount == 0) {
            System.out.println(M);
            return;
        }

        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pSize = Integer.parseInt(st.nextToken());
            int[] party = new int[pSize];

            for (int j = 0; j < pSize; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            // 파티에 참석한 사람들을 하나의 집합으로 합침
            for (int j = 0; j < pSize - 1; j++) {
                union(party[j], party[j + 1]);
            }
        }

        // 거짓말할 수 있는 파티 세기
        int count = 0;
        for (int[] party : parties) {
            boolean canLie = true;
            for (int p : party) {
                // 파티원 중 한 명이라도 진실을 아는 집합에 속해 있는지 확인
                if (isConnectWithTruth(p, truthPeople)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }
        System.out.println(count);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) parent[v] = u;
    }

    private static boolean isConnectWithTruth(int person, int[] truthPeople) {
        int root = find(person);
        for (int truth : truthPeople) {
            if (root == find(truth)) return true;
        }
        return false;
    }
}
