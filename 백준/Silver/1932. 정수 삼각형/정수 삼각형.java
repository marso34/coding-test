import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][]; // 원본 배열 저장
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[i+1];
            dp[i] = new int[i+1];

            for (int j = 0; j <= i; j++) {
                dp[i][j] = arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = dp[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i-1][j-1];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        System.out.println(max);
    }
}