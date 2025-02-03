import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // (2 <= N),
        int m = Integer.parseInt(st.nextToken()); // (M <= 100)

        char[][] map = new char[n][];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>(); // {x, y, 지나온 칸}
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    System.out.println(time + 1);
                    return;
                }

                if (map[nx][ny] == '1' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, time + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}