package d3;

import java.io.*;
import java.util.*;

public class S6808sol1 {
	private static int[] gArr, iArr;
	private static int M=9;
	private static int winCnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=TC; ++tc) {
			boolean[] isPicked = new boolean[19];
			gArr = new int[M];
			iArr = new int[M];
			
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < M; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				isPicked[gArr[i]] = true;
			}
			for (int i=1,j=0; i < 19; i++) {
				if(!isPicked[i]) iArr[j++] = i;
			}
			
			winCnt = 0; // 규영이가 이기는 횟수 
			permutation(0, 0, 0, 0);
			System.out.println("#"+tc+" "+winCnt+" "+(362880-winCnt));
		}
	}
	
	static void permutation(int cnt, int flag, int gScore, int iScore) {
		if(cnt == M) {
			if(gScore>iScore) ++winCnt;
			return;
		}
		
		for (int i = 0; i < M; i++) { // i : 선택할 수의 인덱스 
			if((flag & 1<<i) != 0) continue; // i위치의 비트가 켜있다. 그럼 사용중인수이니 패스
			
			int sum = gArr[cnt] + iArr[i]; // 두 카드의 점수의 합 
			permutation(cnt+1, flag | 1<<i , gScore+(gArr[cnt]>iArr[i]?sum:0), iScore+(gArr[cnt]<iArr[i]?sum:0));
		}
		
	}
}
