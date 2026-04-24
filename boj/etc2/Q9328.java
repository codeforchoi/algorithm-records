package etc2;

import java.io.*;
import java.util.*;

// BFS
public class Q9328 {
    private static int h, w;
    private static char[][] map;
    private static boolean[][] vistied;
    private static boolean[] key;
    private static List<Pos>[] door;
    
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dy = {0, 0, -1, 1};

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2]; // 빌딩 밖까지 구현
            vistied = new boolean[h + 2][w + 2];
            key = new boolean[26]; // a ~ z까지 26개 종류

            // 해당 알파벳문이 여러개 있을 수 있으므로 위치를 여러개 저장할 수 있도록 한다.
            // 문의 위치를 저장함으로써 재방문할 필요가 없다. (움직이는 횟수 제한 x, 동선 제한 x)
            door = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                door[i] = new ArrayList<>();
            }

            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            char[] keys = br.readLine().toCharArray();
            if (keys[0] != '0') {
                for (char ch : keys) {
                    key[ch - 'a'] = true;
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        Queue<Pos> q = new ArrayDeque();
        q.add(new Pos(0, 0)); // 시작 위치 큐에 추가
        vistied[0][0] = true;

        int docs = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            // 4방향으로 모두 이동시켜본다.
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 맵 밖으로 나가는 경우
                if(nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                // 방문했거나 벽인 경우
                if(vistied[nx][ny] || map[nx][ny] == '*') continue;

                char c = map[nx][ny];
                vistied[nx][ny] = true;

                if (c == '.') { // 빈칸인 경우
                    q.add(new Pos(nx, ny));
                } else if (c == '$') { // 문서를 발견한 경우
                    docs++;
                    q.add(new Pos(nx, ny));
                } else if (c >= 'a' && c <= 'z') { // key를 발견한 경우
                    int index = c - 'a';
                    if (!key[index]) {
                        key[index] = true;

                        // 해당 key를 사용할 수 있는 문을 만난적 있다면 큐에 추가
                        for (Pos pos : door[index]) {
                            q.add(pos);
                        }
                        door[index].clear(); // 큐에 추가 했으므로 위치를 지운다.

                    }
                    q.add(new Pos(nx, ny));
                } else if (c >= 'A' && c <= 'Z') { // door를 발견한 경우
                    int index = c - 'A';
                    if (key[index]) { // key가 있는 경우
                        q.add(new Pos(nx, ny));
                    } else { // key가 없는 경우 나중을 위해 문 위치 저장
                        door[index].add(new Pos(nx, ny));
                    }
                }
            }
        }
        return docs;
    }
}
