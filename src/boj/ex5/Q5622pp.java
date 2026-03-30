package boj.ex5;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String inputStr = br.readLine();
        int totalTime = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            char strToChar = inputStr.charAt(i);
            String checkStr = String.valueOf(strToChar);

            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].contains(checkStr)) {
                    totalTime += (j + 3);
                    break;
                }
            }
        }
        System.out.println(totalTime);
    }
}