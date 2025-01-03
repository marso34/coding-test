import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        double max = Math.pow(2, n);
        double result = 0;

        for (int i = 0; i < n; i++) {
            double mid = max / 2;
            double value = max * max / 4;

            if (c >= mid) {
                c -= (int) mid;
                result += value;
            }

            if (r >= mid) {
                r -= (int) mid;
                result += value * 2;
            }

            max = mid;
        }

        System.out.println((int) result);
    }
}