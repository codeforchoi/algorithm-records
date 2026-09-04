package d4;

import java.io.*;
import java.util.*;

public class S1233sol1 {
	class Node {
		char value;
		int left, right;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;		

		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int answer = 1;
			for (int i=0; i<N; i++) {
				String[] _input = br.readLine().split(" ");
				if (answer ==0 ) continue;
				if (isOperation(_input[1]) ^ (_input.length != 2)) {
					answer = 0;					
				} 				
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static boolean isOperation(String str) {
		if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) return true;
		return false;
	}


}
