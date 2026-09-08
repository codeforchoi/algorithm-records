package etc;

import java.io.*;
import java.util.*;

//11
//1 2 3 4 5 6 7 8 9 10 11
public class Permutation_bitmasking {
	static int N, totalCnt;
	static int[] input, numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		totalCnt = 0;
		long start = System.nanoTime();
		pernutation(0, 0);
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	static void pernutation(int cnt, int flag) {
		if(cnt == N) {
			totalCnt++;
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 0; i < N; i++) { // i : 선택할 수의 인덱스
			if((flag & 1 << i) != 0) continue; // i위치의 비트가 켜있다. 그럼 사용중인 수 이므로 패스
			
			numbers[cnt] = input[i];
			pernutation(cnt + 1, flag | 1 << i);			
		}
	}
}
