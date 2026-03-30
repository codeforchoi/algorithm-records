package ex1;

import java.util.Scanner;

public class Q2588 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int B1 = B % 10;
        int B2 = (B / 10) % 10;
        int B3 = B / 100;

        System.out.println(A * B1);
        System.out.println(A * B2);
        System.out.println(A * B3);
        System.out.println(A * B);
    }
}