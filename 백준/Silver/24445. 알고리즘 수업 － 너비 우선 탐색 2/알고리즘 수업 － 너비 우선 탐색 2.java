import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<TreeSet<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new TreeSet<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        bfs(list, r);
    }

    public static void bfs(List<TreeSet<Integer>> list, int v) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[list.size()-1];
        int cnt = 1;

        queue.offer(v);
        visited[v-1] = cnt++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : list.get(cur)) {
                if (visited[i-1] == 0) {
                    visited[i-1] = cnt++;
                    queue.offer(i);
                }
            }
        }

        for (int i : visited) {
            System.out.println(i);
        }
    }
}