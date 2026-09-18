package d;

import java.io.*;
import java.util.*;

// O(N * 4000)
public class S5648sol1 {
	
	static int N = 4001;
	static int[][] map = new int[N][N]; 
    
    private static int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static int[] dy = {1, -1, 0, 0};
    
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
            
            int count = Integer.parseInt(br.readLine()); // 원자 수
            
            Deque<Atom> dq = new ArrayDeque<>();
            int totalEnergy = 0;
            
            for(int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                // 음수 보정 및 0.5초 단위 충돌 대응을 위한 2배 처리
                // -1000 ~ 1000 -> 0 ~ 2000 -> 0 ~ 4000
                int x = (Integer.parseInt(st.nextToken()) + 1000) << 1;
                int y = (Integer.parseInt(st.nextToken()) + 1000) << 1;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                map[y][x] = energy; // 그 위치에 있는 원자들이 가진 에너지를 누적
                dq.addLast(new Atom(x, y, dir, energy));
            }
            
            // 살아 있는 원자들을 이동처리
            while(!dq.isEmpty()) {
            	Atom cur = dq.pollFirst();
            	
            	if(map[cur.y][cur.x] != cur.energy) { // 이 위치에서 충돌
            		totalEnergy += map[cur.y][cur.x];
            		map[cur.y][cur.x] = 0;
            		continue;
            	}
            	
            	// 이동, 현위치에서 원자의 방향으로 다음 위치 계산
            	map[cur.y][cur.x] = 0;
            	int nx = cur.x + dx[cur.dir];
            	int ny = cur.y + dy[cur.dir];
            	
            	if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            	
            	cur.x = nx;
            	cur.y = ny;
            	map[cur.y][cur.x] += cur.energy;
            	
            	dq.addLast(cur);
            }
          
            sb.append(totalEnergy).append("\n");
        }
        System.out.println(sb);
    }

}
