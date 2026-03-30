package level0;

public class P181941 {
    public static void main(String[] args) {
        String[] arr = {"a","b","c"};
        System.out.println(solution(arr));
    }

    public static String solution(String[] arr) {
        return String.join("", arr);
    }
}
