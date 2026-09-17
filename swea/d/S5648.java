package d;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N * 4000)
 * 공간 복잡도 : O(N)
 */
// Memory: 145,468 kb, Time: 2,576 ms, Code Length: 3,506
public class S5648 {
    
    private static final int MIN = -2000;
    private static final int MAX = 2000;
    private static final int MAXINDEX = 4000;
    private static int totalReleasedEnergy = 0;
    
    private static int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static int[] dy = {1, -1, 0, 0};
    
    private static Atom[] atoms;    
    
    private static class Atom {
        int x, y, dir, energy;

        public Atom(int x, int y, int dir, int energy) {
            super();
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }    
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            int N = Integer.parseInt(br.readLine());
            totalReleasedEnergy = 0;
            
            atoms = new Atom[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                atoms[i] = new Atom(x, y, dir, energy);
            }
            
            Set<Integer> set = new HashSet<>(); // 고려할 필요 없는 원자들 집합
            
            while(set.size() != N) {
                
                Set<Integer> duplicated = new HashSet<>(); // 중복되는 원자들 관리
                Map<Integer, Integer> map = new HashMap<>(); // 각 좌표에 위치한 원자들의 개수 저장
                
                // 0.5초씩 이동 시뮬레이션
                for(int i = 0; i < atoms.length; i++) {
                    // 고려할 필요 없는 원자면 넘긴다.
                    if(set.contains(i)) continue;
                        
                    Atom cur = atoms[i];
                    cur.x += dx[cur.dir];
                    cur.y += dy[cur.dir];
                    
                    // 범위 밖을 벗어나면 더 이상 고려할 필요가 없음
                    if(cur.x < MIN || cur.y < MIN || cur.x > MAX || cur.y > MAX) {
                        set.add(i);
                        continue;
                    }
                    
                    int key = cur.x * (MAXINDEX + 1) + cur.y;
                    // 이미 동일한 위치의 원자가 있는 경우
                    if(map.containsKey(key)) {
                        int idx = map.get(key); // 이전 원자를 저장
                        duplicated.add(i);
                        duplicated.add(idx);
                    } else {
                        map.put(key, i);
                    }                    
                }                
                
                // 충돌된 원소를 고려할 필요 없는 원자들 집합에 넣음.
                for(Integer idx : duplicated) {
                    set.add(idx);
                    totalReleasedEnergy += atoms[idx].energy;
                }                
            }
            sb.append(totalReleasedEnergy).append("\n");
        }
        System.out.println(sb);
    }
}
