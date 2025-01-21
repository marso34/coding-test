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
        char[][] map = new char[12][];
        int cnt = 0;

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean isPop = bfs(map);
            downPuyo(map);

            if (!isPop)
                break;

            cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean bfs(char[][] map) {
        boolean isPop = false;

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[12][6];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || visited[i][j])
                    continue;

                char color = map[i][j];

                List<int[]> list = new ArrayList<>();
                queue.offer(new int[]{i, j});
                list.add(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
                            continue;

                        if (!visited[nx][ny] && map[nx][ny] == color) {
                            visited[nx][ny] = true;
                            list.add(new int[]{nx, ny});
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }

                if (list.size() >= 4) {
                    for (int[] puyo : list) {
                        map[puyo[0]][puyo[1]] = '.';
                    }

                    isPop = true;
                }
            }
        }

        return isPop;
    }

    public static void downPuyo(char[][] map) {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.')
                    continue;

                int ni = i;
                while (ni + 1 < 12 && map[ni + 1][j] == '.') {
                    ni++;
                }

                if (ni == i)
                    continue;

                map[ni][j] = map[i][j];
                map[i][j] = '.';
            }
        }
    }
}
