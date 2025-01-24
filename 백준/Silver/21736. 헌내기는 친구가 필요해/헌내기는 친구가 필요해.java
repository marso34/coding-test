import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    boolean[][] visited = new boolean[n][m];
                    bfs(map, visited, i, j);
                    break loop;
                }
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    public static void bfs(char[][] map, boolean[][] visited, int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visited[x][y] = true;

        if (map[x][y] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }

            if (visited[nx][ny] || map[nx][ny] == 'X') {
                continue;
            }

            bfs(map, visited, nx, ny);
        }
    }
}