package ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4949sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            else sb.append(isVPS(line)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static String isVPS(String line) {
        char[] stack = new char[line.length()];
        int size = 0;

        for (char ch : line.toCharArray()) {
            switch(ch) {
                case '(': case'[':
                    stack[size] = ch;
                    size++;
                    break;
                case ')':
                    if(size == 0 || stack[size - 1] != '(') return "no";
                    else size--;
                    break;
                case ']':
                    if(size == 0  || stack[size - 1] != '[') return "no";
                    else size--;
                default:
                    break;
            }
        }
        if (size == 0) return "yes";
        else return "no";
    }
}