package programmers.level0;

public class P181928 {
    public static void main(String[] args) {
        int[] list = {3, 4, 5, 2, 1};
        System.out.println(solution(list));
    }

    public static int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int i : num_list) {
            (i % 2 == 0 ? even : odd).append(i);
        }
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}
