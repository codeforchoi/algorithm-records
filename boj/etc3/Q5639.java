package etc3;

import java.io.*;

//
public class Q5639 {
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

        // 트리에 새로운 노드를 삽입하는 함수
        void insert(int n) {
            if (n < this.val) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄이 루트 노드
        String input = br.readLine();
        if (input == null || input.equals("")) return;

        Node root = new Node(Integer.parseInt(input));

        // EOF까지 입력받아 트리 구축
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }

        // 후위 순회 시작
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);   // 왼쪽
        postOrder(node.right);  // 오른쪽
        System.out.println(node.val); // 루트
    }

}
