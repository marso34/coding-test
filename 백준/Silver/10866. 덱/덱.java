import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int temp = 0;
            
            switch(str[0]) {
                case "push_front":
                    list.addFirst(Integer.parseInt(str[1]));
                    break;

                case "push_back":
                    list.addLast(Integer.parseInt(str[1]));
                    break;

                case "pop_front":
                    temp = list.peek() != null ? list.poll() : -1;
                    System.out.println(temp);
                    break;

                case "pop_back":
                    temp = list.peekLast() != null ? list.pollLast() : -1;
                    System.out.println(temp);
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "empty":
                    temp = list.isEmpty() ? 1 : 0;
                    System.out.println(temp);
                    break;

                case "front":
                    temp = list.peek() != null ? list.peek() : -1;
                    System.out.println(temp);
                    break;

                case "back":
                    temp = list.peekLast() != null ? list.peekLast() : -1;
                    System.out.println(temp);
                    break;
            }
        }
    }
}