package etc3;

import java.io.*;
import java.util.*;

//
public class Q1379 {
    private static class Lecture {
        int idx, start, end;

        Lecture(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }

    private static class Room {
        int end, num;

        Room(int end, int num) {
            this.end = end;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(idx, s, e);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Room> using = new PriorityQueue<>(
                (a, b) -> a.end - b.end
        );

        PriorityQueue<Integer> empty = new PriorityQueue<>();

        int[] answer = new int[N + 1];
        int roomCount = 0;

        for (Lecture lec : arr) {
            while (!using.isEmpty() && using.peek().end <= lec.start) {
                empty.offer(using.poll().num);
            }

            int roomNum;
            if (!empty.isEmpty()) {
                roomNum = empty.poll();
            } else {
                roomNum = ++roomCount;
            }
            answer[lec.idx] = roomNum;
            using.offer(new Room(lec.end, roomNum));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append('\n');
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
}
