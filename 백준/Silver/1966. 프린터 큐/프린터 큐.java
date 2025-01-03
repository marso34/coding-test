import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Print {
    int index;
    int priority;

    public Print(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스의 수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 문서의 위치

            LinkedList<Print> queue = new LinkedList<>();
            Print target = null;

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.offer(new Print(j, Integer.parseInt(st.nextToken())));

                if (j == m) {
                    target = queue.peekLast();
                }
            }

            for (int j = 0; j < n; j++) {
                int max = 0;

                for (int k = j; k < queue.size(); k++) {
                    max = Math.max(max, queue.get(k).priority);
                }

                while (queue.get(j).priority < max) {
                    queue.offer(queue.remove(j));
                }
            }

            int index = queue.indexOf(target) + 1;
            System.out.println(index);
        }
    }
}