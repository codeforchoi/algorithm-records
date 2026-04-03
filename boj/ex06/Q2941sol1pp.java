package ex06;
//포스팅
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2941sol1pp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] ca = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : ca) {
            inputStr = inputStr.replace(s, ".");
        }
        System.out.println(inputStr.length());
    }
}
