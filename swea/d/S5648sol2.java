package d;

import java.io.*;
import java.util.*;

public class S5648sol2 {
	
	private static int N;
	private static Atom[] list;
    
    private static int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static int[] dy = {1, -1, 0, 0};
    
    private static class Atom implements Comparable<Atom> {
        int x, y, dir, energy;

        public Atom(int x, int y, int dir, int energy) {
            super();
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }

		@Override
		public int compareTo(Atom o) {
			int diff = Integer.compare(this.x, o.x);
			return diff != 0 ? diff : Integer.compare(this.y, o.y);
		}                  
    }
    
    // 조합의 쌍
    private static class Pair {
    	int i, j, time; // 쌍의 인덱스 번호, 충돌시간

		public Pair(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}    	
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            N = Integer.parseInt(br.readLine()); // 원자 수     
            
            list = new Atom[N];
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                // 음수 보정 및 0.5초 단위 충돌 대응을 위한 2배 처리
                // -1000 ~ 1000 -> 0 ~ 2000 -> 0 ~ 4000
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());          
                
                list[i] = new Atom(x, y, dir, energy);
            }       
           
          
            sb.append(makeBoomPair()).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int makeBoomPair() { // 충돌 가능한 원자 쌍의 리스트 생성
    	Arrays.sort(list);
    	List<Pair> boomPairs = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		for(int j = i + 1; j < N; j++) {
    			
    			Atom a = list[i], b = list[j];
    			
    			// 수직에서 만날 때 (x 좌표가 같다)
    			if(a.x == b.x) {
    				if(a.dir == 0 && b.dir == 1) 
    					boomPairs.add(new Pair(i, j, Math.abs(b.y - a.y) / 2));
    			}
    			
    			// 수평에서 만날 때
    			if(a.y == b.y) {
    				if(a.dir == 3 && b.dir == 2) 
    					boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
    			}
    			
    			// / 대각라인 원자들이 만날 때
    			if(a.x - a.y == b.x - b.y) {
    				if(a.dir == 3 && b.dir == 1 || a.dir == 0 && b.dir == 2) 
    					boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
    			}
    			
    			// \ 대각라인 원자들이 만날 때
    			if(a.x + a.y == b.x + b.y) {
    				if(a.dir == 1 && b.dir == 2 || a.dir == 3 && b.dir == 0)
    					boomPairs.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
    			}
    		}
    	}
    	return getTotalEnergy(boomPairs);
    }
    
    private static int getTotalEnergy(List<Pair> boomPairs) {
    	Collections.sort(boomPairs, (o1, o2) -> o1.time <= o2.time ? -1 : 1); // 소멸되는 시간에 따라 정렬
    	int sum = 0;
    	
    	final int INF = Integer.MAX_VALUE;
    	int boomTimes[] = new int[N]; // 각 원자들이 폭발하는 가장 빠른 시간 기록
    	Arrays.fill(boomTimes, INF); // 최대값으로 초기화
    	
    	for(Pair p : boomPairs) {
    		if(boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
    		
    		if(boomTimes[p.i] == INF) { // 안터졌다면
    			boomTimes[p.i] = p.time;
    			sum += list[p.i].energy;
    		}
    		
    		if(boomTimes[p.j] == INF) { // 안터졌다면
    			boomTimes[p.j] = p.time;
    			sum += list[p.j].energy;
    		}
    	}    	
    	return sum;
    }
}
