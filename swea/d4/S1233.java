package d4;

import java.io.*;
import java.util.*;

public class S1233 {	
	private static final int TEST_CASES = 10;
	private static Queue<Node> queue;
	private static List<Node> list;
	
	public static class Node {
		Character value;
		Integer left;
		Integer right;
		
		public Node(Character value, Integer left, Integer right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= TEST_CASES; tc++) {
			sb.append("#").append(tc).append(" ");
			queue = new ArrayDeque<>();
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			
			list.add(new Node(null, null, null));
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();
				Character ch = str.charAt(0);				
				Integer childA = (st.hasMoreTokens()) ? Integer.parseInt(st.nextToken()) : null;
				Integer childB = (st.hasMoreTokens()) ? Integer.parseInt(st.nextToken()) : null;
				list.add(new Node((char)ch, childA, childB));				
			}
			
			dfs(1);
			
			boolean canOperate = true;
			boolean isPreNum = false;
						
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				boolean isCurrNum = Character.isDigit(node.value);
				
				// 숫자 연속일 경우 오류, 연산자 연속일 경우 오류 
				if(!(isPreNum ^ isCurrNum)) {
					canOperate = false;
					break;
				}				
				
				// 숫자인 경우
				isPreNum = isCurrNum;			
			}
			if(isPreNum && canOperate) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 중위 순회
	private static void dfs(int depth) {
		Node node = list.get(depth);
		if(node.left != null) {
			dfs(node.left);
		}
		
		queue.offer(node);
		
		if(node.right != null) {
			dfs(node.right);
		}
	}
}
