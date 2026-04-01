package level1;

public class P12948sol1 {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }

    public static String solution(String phone_number) {
        char[] arr = phone_number.toCharArray();
        for (int i = 0; i < arr.length - 4; i++) {
            arr[i] = '*';
        }
        return String.valueOf(arr);
    }
}
