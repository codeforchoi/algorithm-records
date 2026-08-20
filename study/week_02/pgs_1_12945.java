package week_02;

public class pgs_1_12945 {
	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
	
	public static int solution(int n) {
        int divide = 1234567;
        int[] fibo = new int[n + 1];
        
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i = 2; i <= n; i++) {
        	fibo[i] = (fibo[i - 2] + fibo[i - 1]) % divide;
        }
        
        return fibo[n];
    }
}
