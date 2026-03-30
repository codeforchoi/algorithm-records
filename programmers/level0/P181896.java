package level0;

public class P181896 {
    public static void main(String[] args) {
        int[] list = {12, 4, 15, 46, 38, -2, 15};
        System.out.println(solution(list));
    }

    public static int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
