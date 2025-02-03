import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][];
        boolean[][] visited = new boolean[n][n];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    result.add(bfs(map, visited, i, j));
                }
            }
        }

        result.sort(null);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    public static int bfs(char[][] map, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) {
                    continue;
                }

                if (map[nx][ny] == '1' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return count;
    }
}