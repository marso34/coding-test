import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int temp = 0;
            
            switch(str[0]) {
                case "push":
                    stack.push(Integer.parseInt(str[1]));
                    break;

                case "pop":
                    temp = !stack.isEmpty() ? stack.pop() : -1;
                    System.out.println(temp);
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    temp = stack.isEmpty() ? 1 : 0;
                    System.out.println(temp);
                    break;

                case "top":
                    temp = !stack.isEmpty() ? stack.peek() : -1;
                    System.out.println(temp);
                    break;
            }
        }
    }
}