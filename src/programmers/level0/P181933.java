package programmers.level0;

public class P181933 {
    public static void main(String[] args) {

        System.out.println(solution(-4, 7, true));
    }

    public static int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }
}
