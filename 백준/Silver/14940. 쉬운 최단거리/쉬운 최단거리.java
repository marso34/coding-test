import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] result = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;

                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    result[i][j] = 0;
                } else if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i]; 
                int nextD = current[2] + 1;

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (result[nextX][nextY] < 1 && map[nextX][nextY] == 1) {
                    queue.offer(new int[]{nextX, nextY, nextD});
                    result[nextX][nextY] = nextD;
                }
            }
        }

        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}