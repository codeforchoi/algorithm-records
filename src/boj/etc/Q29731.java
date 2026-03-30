package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = {
                "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"
        };
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (String str : arr) {
                if (input.equals(str)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count == n ? "No" : "Yes");
    }
}
