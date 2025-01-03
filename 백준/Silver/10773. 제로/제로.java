import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 정수의 수

        Stack<Integer> queue = new Stack<>();

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                queue.pop();
            } else {
                queue.push(input);
            }
        }

        int sum = 0;
        
        for (int i : queue) {
            sum += i;
        }
        
        System.out.println(sum);
    }
}