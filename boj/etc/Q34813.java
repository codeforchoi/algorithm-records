package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char code = br.readLine().charAt(0);
        switch(code) {
            case 'F':
                System.out.println("Foundation");
                break;
            case 'C':
                System.out.println("Claves");
                break;
            case 'V':
                System.out.println("Veritas");
                break;
            case 'E':
                System.out.println("Exploration");
                break;
            default:
        }
    }
}
