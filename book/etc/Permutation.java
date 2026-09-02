package etc;

import java.util.*;

/**
 * 순열
 */
public class Permutation {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] arr = {1, 2, 3, 4, 5};
        boolean[] visited = new boolean[n];
        int[] result = new int[k];
        permutation1(arr, visited, result, 0);
    }

    public static void permutation1(int[] arr, boolean[] visited, int[] result, int depth) {

        if (depth == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            result[depth] = arr[i];

            permutation1(arr, visited, result, depth + 1);

            visited[i] = false;
        }
    }
}
