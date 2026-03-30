package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            switch(str) {
                case "animal":
                    sb.append("Panthera tigris");
                    break;
                case "tree":
                    sb.append("Pinus densiflora");
                    break;
                case "flower":
                    sb.append("Forsythia koreana");
                    break;
                default:
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
