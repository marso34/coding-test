import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = arr[0];

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(arr[i][j] + dp[i-1][(j+1)%3], arr[i][j] + dp[i-1][(j+2)%3]);

                if (i == n-1 && dp[i][j] < min) {
                    min = dp[i][j];
                }
            }
        }

        System.out.println(min);
    }
}