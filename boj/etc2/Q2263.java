package etc2;

import java.io.*;
import java.util.*;

// 프리오더(전위 순회), 인오더(중위 순회), 포스트오더(후위 순회)
// preorder: root - left - right (항상 root가 먼저)
// inorder: left - root - right (root를 기준으로 왼쪽 오른쪽 구분 가능)
// postorder: left - right - root (root가 항상 맨 뒤)
public class Q2263 {
    private static int[] inorder, postorder;
    private static int[] index;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        index = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            index[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
        // 
        if(inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd]; // root는 항상 postorder의 맨 마지막
        sb.append(root).append(" ");

        int rootIndex = index[root];
        int leftSize = rootIndex - inStart; // 루트 왼쪽 서브트리 정점 개수들

        // 왼쪽 서브트리
        preorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        // 오른쪽 서브트리
        preorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);  // postEnd - 1 은 마지막은 root노드니까
    }
}
