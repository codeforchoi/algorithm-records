package level0;

public class P181926sol1 {
    public static void main(String[] args) {
        System.out.println(solution(0, "wsdawsdassw"));
    }

    public static int solution(int n, String control) {
        return control.chars().reduce(n, (temp, c) -> temp + (c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10));
    }
}
