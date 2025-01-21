import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int v = Integer.parseInt(st.nextToken()) - 1; // 시작할 정점

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        boolean[] visited = new boolean[n];

        dfs(graph, v, visited);
        System.out.println();
        bfs(graph, v);
    }

    public static void dfs(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+1 + " ");

        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void bfs(int[][] graph, int v) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+1 + " ");

            for (int i = 0; i < graph.length; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
