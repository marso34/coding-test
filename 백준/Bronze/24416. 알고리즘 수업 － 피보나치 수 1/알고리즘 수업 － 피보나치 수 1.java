import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] dp;
    static int recursionCnt = 0;
    static int dpCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        fib(n);
        fibonacci(n);

        System.out.println(recursionCnt + " " + dpCnt);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursionCnt++;
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static int fibonacci(int n) {
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dpCnt++;
        }

        return dp[n];
    } 
}