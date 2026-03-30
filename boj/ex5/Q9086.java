package ex5;

import java.util.Scanner;

public class Q9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[3];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.nextLine();
        }

        for (String str : strs) {
            System.out.println("" + str.charAt(0) + str.charAt(str.length()-1));
        }
    }
}