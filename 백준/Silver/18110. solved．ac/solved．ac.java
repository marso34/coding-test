import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 의견의 수

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int cnt = 0;
        int exclude= (int) Math.round(n * 0.15);

        for (int i = exclude; i < n - exclude; i++) {
            sum += arr[i];
            cnt++;
        }

        System.out.println(Math.round((double) sum / cnt));
    }
}