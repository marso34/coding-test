import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        loop1:
        for (int i = 0; i < n; i++) {
            Queue<Character> list = new LinkedList<>();
            
            for (char ch : br.readLine().toCharArray()) {
                if (ch == '(') {
                    list.add(ch);
                } else if (list.peek() != null) {
                    list.poll();
                } else {
                    System.out.println("NO");
                    continue loop1;
                }
            }
            
            if (list.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}