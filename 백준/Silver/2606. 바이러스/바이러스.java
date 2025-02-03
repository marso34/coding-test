import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(graph, visited, 0);

        System.out.println(cnt);
    }

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);

            if (!visited[next]) {
                cnt++;
                dfs(graph, visited, next);
            }
        }
    }
}