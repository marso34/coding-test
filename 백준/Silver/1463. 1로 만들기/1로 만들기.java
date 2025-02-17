import java.io.*;
import java.lang.Math;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = 1;

        for (int i = n-2; i > 0; i--) {
            dp[i] = dp[i+1] + 1;
            
            if (i * 3 <= n) {
                dp[i] = Math.min(dp[i * 3] + 1, dp[i]);
            }
            
            if (i * 2 <= n) {
                dp[i] = Math.min(dp[i * 2] + 1, dp[i]);
            }
        }

        System.out.println(dp[1]);
    }
}