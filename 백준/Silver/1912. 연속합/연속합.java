import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int currentMax = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], arr[i] + currentMax);
            max = Math.max(max, currentMax);
        }

        System.out.println(max);
    }
}