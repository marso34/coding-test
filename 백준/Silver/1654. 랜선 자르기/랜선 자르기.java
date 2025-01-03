import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선의 수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 수
        long min = 0, max = 0;

        int arr[] = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max++;

        while (min < max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= N) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}