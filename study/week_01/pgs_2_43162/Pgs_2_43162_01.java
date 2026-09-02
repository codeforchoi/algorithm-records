package week_01.pgs_2_43162;

public class pgs_2_43162_01 {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}

	public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int cur, int[][] computers, boolean[] vistied) {
        vistied[cur] = true;

        for(int i = 0; i < computers.length; i++) {
            if(computers[cur][i] == 1 && !vistied[i]) {
                dfs(i, computers, vistied);
            }
        }
    }
}
