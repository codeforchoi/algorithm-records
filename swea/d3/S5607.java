package d3;

import java.io.*;
import java.util.*;

/**
 * 페르마의 소정리
 * a^(p-1) == 1
 * a^(p-2) == 1/a
 * nCr == n! / (n-r)! * r! == n! * 1/(n-r)! * 1/r!
 * nCr % p = n! % p * ((n-r)!)^(p-2) % p * ((r!)^(p-2)) % p
 * 나눗셈의 나머지 정리는 없고 곱셉의 나머지 정리 사용
 * 분할정복 알고리즘을 사용
 * 
 * 시간 복잡도 : O(M + T log P) (M: 1_000_000, T: 테스트 케이스 수, P: 1234567891) => O(1) ?   
 * 공간 복잡도 : O(M + T + log P)
 */
// Memory: 34,072 kb, Time: 86 ms, Code Length: 1,608

public class S5607 {
	
	private static final int P = 1_234_567_891;
	private static long[] memoFactorial;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		factorial(1_000_000);
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long numerator = memoFactorial[N];
			long denominator = memoFactorial[N - R] * memoFactorial[R] % P;
			long inverse = divideAndConquer(denominator, P - 2);			
			long answer = numerator * inverse % P;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void factorial(int n) {
		memoFactorial = new long[n + 1];
		
		memoFactorial[0] = memoFactorial[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			memoFactorial[i] = i * memoFactorial[i - 1] % P;
		}
	}
	
	private static long divideAndConquer(long n, int p) {
		if(p == 0) return 1;
		
		long result = divideAndConquer(n, p / 2);
		result = result * result % P;
		
		return (p % 2 == 0) ? result : result * n % P; 		
	}	
}
