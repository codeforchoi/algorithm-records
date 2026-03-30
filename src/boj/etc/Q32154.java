package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q32154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new HashMap<>(Map.of(
                1, "11\nA B C D E F G H J L M",
                2, "9\nA C E F G H I L M",
                3, "9\nA C E F G H I L M",
                4, "9\nA B C E F G H L M",
                5, "8\nA C E F G H L M",
                6, "8\nA C E F G H L M",
                7, "8\nA C E F G H L M",
                8, "8\nA C E F G H L M",
                9, "8\nA C E F G H L M",
                10, "8\nA B C F G H L M"
        ));
        int n = Integer.parseInt(br.readLine());
        System.out.println(map.get(n));
    }
}
