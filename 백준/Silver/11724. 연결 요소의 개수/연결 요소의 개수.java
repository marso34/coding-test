import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;

        for (int i : graph.get(start)) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }
}
