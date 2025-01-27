import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Character, Character> colorMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result1 = 0;
        int result2 = 0;

        char[][] map = new char[n][];
        boolean[][] visited1 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];

        colorMap = new HashMap<>();
        colorMap.put('R', 'G');
        colorMap.put('G', 'R');
        colorMap.put('B', 'B');

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    dfs(map, visited1, i, j);
                    result1++;
                }

                if (!visited2[i][j]) {
                    dfs(map, visited2, colorMap.get(map[i][j]), i, j);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    public static void dfs(char[][] map, boolean[][] visited, int x, int y) {
        int n = map.length;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == map[x][y]) {
                dfs(map, visited, nx, ny);
            }
        }
    }

    public static void dfs(char[][] map, boolean[][] visited, char color, int x, int y) {
        int n = map.length;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == map[x][y] || map[nx][ny] == color) {
                dfs(map, visited, map[nx][ny] == color ? colorMap.get(color) : color, nx, ny);
            }
        }
    }
}