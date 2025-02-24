import java.io.*;
import java.util.*;

class Main {

    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;

        List<TreeSet<Integer>> list = new ArrayList<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(visited, list, r);

        for (int i : visited) {
            System.out.println(i);
        }
    }

    public static void dfs(int[] visited, List<TreeSet<Integer>> list, int v) {
        visited[v] = cnt++;

        for (int i : list.get(v)) {
            if (visited[i] == 0) {
                dfs(visited, list, i);
            }
        }
    }
}