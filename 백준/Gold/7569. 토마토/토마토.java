import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int total = 0;

        int[][][] map = new int[k][n][m];
        boolean[][][] visited = new boolean[k][n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < m; l++) {
                    map[i][j][l] = Integer.parseInt(st.nextToken());

                    if (map[i][j][l] == 1) {
                        queue.add(new int[]{i, j, l});
                    } else if (map[i][j][l] == -1) {
                        total++; // -1인, 토마토가 들어있지 않은 칸의 개수
                    }
                }
            }
        }

        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (true) {
            Queue<int[]> tempQueue = new LinkedList<>();
            total += queue.size(); // 1인, 익은 토마토의 개수

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int z = current[0];
                int x = current[1];
                int y = current[2];

                visited[z][x][y] = true;

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= k) {
                        continue;
                    }

                    if (visited[nz][nx][ny] || map[nz][nx][ny] != 0) {
                        continue;
                    }

                    map[nz][nx][ny] = 1;
                    tempQueue.add(new int[]{nz, nx, ny});
                }
            }

            if (tempQueue.isEmpty()) {
                break;
            }

            queue.addAll(tempQueue);
            cnt++;
        }

        System.out.println(total == k * n * m ? cnt : -1); // 모든 곳을 방문했다면 total과 k * n * m이 같아야 함
    }
}