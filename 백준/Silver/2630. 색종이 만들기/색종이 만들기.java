import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int x, int y, int size) {
        if (isCorrect(x, y, size)) {
            return;
        }

        size /= 2;

        int[] dx = {0, 0, size, size};
        int[] dy = {0, size, 0, size};

        for (int i = 0; i < 4; i++) {
            divide(x + dx[i], y + dy[i], size);
        }
    }

    public static boolean isCorrect(int x, int y, int size) {
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[x + i][y + j] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt == size * size) {
            blue++;
            return true; 
        } else if (cnt == 0) {
            white++;
            return true;
        }

        return false;
    }
}