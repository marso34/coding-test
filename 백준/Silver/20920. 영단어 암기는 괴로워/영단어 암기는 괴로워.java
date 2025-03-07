import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.length() < m) {
                continue;
            }

            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator
            .comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
            .thenComparing(entry -> entry.getKey().length(), Comparator.reverseOrder())
            .thenComparing(Map.Entry::getKey));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (Map.Entry<String, Integer> entry : list) {
            bw.write(entry.getKey());
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}