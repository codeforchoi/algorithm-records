package etc;

import java.util.Scanner;

//N-Queen + 비트마스킹
public class NQuuen {
	
	static int N, cnt;
	static boolean[] col, mainDiagonal, subDiagonal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 맵의 크기
		cnt = 0;
		
		col = new boolean[N + 1];
		mainDiagonal = new boolean[2 * N + 1];
		subDiagonal = new boolean[2 * N + 1];
		
		setQueen(1);
		System.out.println(cnt);		
	}
	
	static void setQueen(int row) {
		if(row > N) {
			// 유망할 때만 계속 트리를 탐색해서 왔는데 기저조건이면 무조건 답
			++cnt;
			return;
		}
		
		// 1열부터 N열까지 시도
		for(int c = 1; c <= N; c++) {
			if(!isAvailable(row, c)) continue; // 가지치기
			col[c] = mainDiagonal[(row - c) + N] = subDiagonal[row + c] = true;
			setQueen(row + 1);
			col[c] = mainDiagonal[(row - c) + N] = subDiagonal[row + c] = false;
		}
	}
	
	static boolean isAvailable(int r, int c) {
		return !col[c] && !mainDiagonal[(r - c) + N] && !subDiagonal[r + c];		
	}

}
