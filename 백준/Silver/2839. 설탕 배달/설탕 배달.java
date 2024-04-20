import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int r = n % 5;
        int answer = n / 5;

        if (r == 1 || r == 3) {
            answer++;
        } else if (r == 2 || r == 4) {
            answer += 2;
        }

        if (n == 4 || n == 7)
            answer = -1;

        System.out.println(answer);
    }
}