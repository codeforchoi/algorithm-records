package etc3;

import java.util.*;
import java.io.*;

//
public class Q14725 {
    private static class Node {
        // TreeMap을 사용하여 자식 노드들을 자동으로 사전순 정렬
        Map<String, Node> child = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node current = root;

            for (int j = 0; j < K; j++) {
                String food = st.nextToken();
                // 자식 중에 해당 먹이가 없으면 새로 추가
                if (!current.child.containsKey(food)) {
                    current.child.put(food, new Node());
                }
                current = current.child.get(food);
            }
        }
        print(root, 0);
    }

    private static void print(Node node, int depth) {
        for (String key : node.child.keySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            print(node.child.get(key), depth + 1);
        }
    }
}
