package ex03;

import java.util.Scanner;

public class Q25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        int totalAmount = 0;

        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();
            int quantity = sc.nextInt();
            totalAmount += price * quantity;
        }

        if (totalAmount == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}