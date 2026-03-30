package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29766sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str.split("DKSH", -1).length - 1);
        // split(특정문자를 기준으로 자름, 제한 수)
        // 양수 -> 최대 몇 개로 나눌지 제한
        // 0 -> 끝의 빈 문자열은 버림
        // 음수 -> 끝의 빈 문자열도 포함해서 전부 나눔
    }
}
