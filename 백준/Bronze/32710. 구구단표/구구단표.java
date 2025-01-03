import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정수의 수

        boolean isMulti = false; // 구구단인지

        for (int i = 2; i < 10; i++) {
            if (N % i == 0 && N < i * 10) {
                isMulti = true;
                break;
            }
        }

        if (N == 1)
            isMulti = true;

        if (N == 100)
            isMulti = false;

        System.out.print(isMulti ? 1 : 0);
    }
}