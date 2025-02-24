import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {
            int currentMax = dp[i];

            for (int j = 0; i - j >= 0; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > currentMax) {
                    currentMax = dp[j] + 1;
                }
            }

            dp[i] = currentMax;

            if (currentMax > max) {
                max = currentMax;
            }
        }

        System.out.println(max);
    }
}