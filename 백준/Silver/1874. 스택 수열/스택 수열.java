import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = 1;

        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean isPossible = false;

            while (k <= num) {
                stack.push(k++);
                result.add("+");
            }

            if (stack.peek() == num) {
                stack.pop();
                result.add("-");
                isPossible = true;
            }

            if (!isPossible) {
                result.clear();
                result.add("NO");
                break;
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}