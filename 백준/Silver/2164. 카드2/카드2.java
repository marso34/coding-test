import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        boolean isFirst = false;
        
        while (queue.size() > 1) {
            int t = queue.poll();

            if (isFirst) {
                queue.add(t);
            }

            isFirst = !isFirst;
        }

        System.out.println(queue.peek());
    }
}