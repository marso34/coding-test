import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    maxHeap.add(num);
                    minHeap.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (num == 1) {
                        remove(maxHeap, map);
                    } else {
                        remove(minHeap, map);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else if (map.size() == 1) {
                int result = remove(maxHeap, map);
                System.out.println(result + " " + result);
            } else {
                System.out.println(remove(maxHeap, map)+ " " + remove(minHeap, map));
            }
        }
    }

    public static int remove(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!map.isEmpty()) {
            int num = heap.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0) {
                continue;
            } else if (cnt == 1) {
                map.remove(num);
            } else {
                map.put(num, cnt - 1);
            }

            return num;
        }

        return 0;
    }
}

