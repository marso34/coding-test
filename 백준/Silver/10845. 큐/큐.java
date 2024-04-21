import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int temp = 0;
            
            switch(str[0]) {
                case "push":
                    queue.add(Integer.parseInt(str[1]));
                    break;

                case "pop":
                    temp = queue.peek() != null ? queue.poll() : -1;
                    System.out.println(temp);
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    temp = queue.isEmpty() ? 1 : 0;
                    System.out.println(temp);
                    break;

                case "front":
                    temp = queue.peek() != null ? queue.peek() : -1;
                    System.out.println(temp);
                    break;

                case "back":
                    temp = queue.peekLast() != null ? queue.peekLast() : -1;
                    System.out.println(temp);
                    break;
            }
        }
    }
}