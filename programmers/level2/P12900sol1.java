package level2;

// dp, 공간복잡도를 줄인 방법
public class P12900sol1 {
	public int solution(int n) {
        final int P = 1_000_000_007;
    
        int prev_2 = 1;
        int prev_1 = 2;
        int result = 0;
        
        for(int i = 3; i <= n; i++) {
            result = (prev_1 + prev_2) % P;
            prev_2 = prev_1;
            prev_1 = result;
        }
        
        return result;
    }
}
