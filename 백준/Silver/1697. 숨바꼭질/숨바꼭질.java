import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 0 <= n <= 100,000
        int k = Integer.parseInt(st.nextToken()); // 0 <= k <= 100,000

        if (n == k) {
            System.out.println(0);
            return;
        }

        int max = 100001;
        boolean[] visited = new boolean[max];

        Queue<int[]> queue = new LinkedList<>(); // {위치, 시간}
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int position = current[0];
            int time = current[1];

            // 걷는다면 x - 1, x + 1
            // 순간이동한다면 2 * x
            int[] nextPosition = {position - 1, position + 1, 2 * position};

            for (int next : nextPosition) {
                if (next == k) {
                    System.out.println(time + 1);
                    return;
                }

                if (next >= 0 && next < max && !visited[next]) {
                    queue.add(new int[]{next, time + 1});
                    visited[next] = true;
                }
            }
        }
    }
}