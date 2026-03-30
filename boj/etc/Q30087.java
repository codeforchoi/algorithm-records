package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>(Map.of(
                "Algorithm", "204",
                "DataAnalysis", "207",
                "ArtificialIntelligence", "302",
                "CyberSecurity", "B101",
                "Network", "303",
                "Startup", "501",
                "TestStrategy", "105"
        ));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
