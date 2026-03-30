package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9654 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n")
                .append("N2 Bomber      Heavy Fighter  Limited    21        \n")
                .append("J-Type 327     Light Combat   Unlimited  1         \n")
                .append("NX Cruiser     Medium Fighter Limited    18        \n")
                .append("N1 Starfighter Medium Fighter Unlimited  25        \n")
                .append("Royal Cruiser  Light Combat   Limited    4         ");
        System.out.println(sb);
    }
}
