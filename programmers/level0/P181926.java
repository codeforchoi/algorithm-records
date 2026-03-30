package level0;

public class P181926 {
    public static void main(String[] args) {
        System.out.println(solution(0, "wsdawsdassw"));
    }

    public static int solution(int n, String control) {
        for (String s : control.split("")) {
            switch(s) {
                case"w":
                    n++; break;
                case "s":
                    n--; break;
                case "d":
                    n += 10; break;
                case "a":
                    n -= 10; break;
                default:
            }
        }
        return n;
    }
}
