import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+2]; // n이 1일 때 대비

        dp[1] = 1; // N = 1 -> 1
        dp[2] = 2; // N = 2 -> 00, 11
        // dp[3] = // 001, 111, 100 -> dp[2]뒤에 '1'추가 + dp[1] 뒤에' 00'추가
        // dp[4] = // 0011, 1111, 1001, 0000, 1100, -> dp[3] 뒤체 '1'추가 + dp[2] 뒤에 '00'추가
        // dp[i] = dp[i-1] + dp[i-2];  

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[n] % 15746);
    }
}